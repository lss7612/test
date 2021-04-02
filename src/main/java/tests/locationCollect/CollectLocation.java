package tests.locationCollect;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Controller
public class CollectLocation {
	private static Gson gson = new GsonBuilder().setLenient().create();
	private static OkHttpClient okHttpClient1 = new OkHttpClient.Builder().build();
	private static OkHttpClient okHttpClient2 = new OkHttpClient.Builder().build();
	private static Retrofit retrofit_meetEat = new Retrofit.Builder()
			.baseUrl("http://localhost:8088/")
			.client(okHttpClient1)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build();
	private static Retrofit retrofit_mktView = new Retrofit.Builder()
			.baseUrl("http://localhost:8087/")
			.client(okHttpClient2)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build();
	
	private static CollectLocationRetrofitService meetEatService = retrofit_meetEat.create(CollectLocationRetrofitService.class);
	private static CollectLocationRetrofitService mktViewService = retrofit_mktView.create(CollectLocationRetrofitService.class);
	
	public static void main(String[] args) {
		
		try {
			//=================  엑셀파일에서 시트 가져오기 =======================
			FileInputStream fis = new FileInputStream("C:\\Users\\이상성\\Desktop\\workspace\\Test\\src\\main\\webapp\\resources\\adm_code.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // 첫번째 씨트를 가져온다
			int row_length = sheet.getPhysicalNumberOfRows(); //시트의 행이 몇갠지 확인하고 변수에 저장
			String[] arr_location = new String[row_length]; //행 길이만큼 배열 생성
			
			
			
			//================ 각 행의 Cell에서 지역정보를 빼오기 =====================
			String location_name = "";
			for(int rowIdx = 0; rowIdx < row_length; rowIdx++) {
				XSSFRow row = sheet.getRow(rowIdx);
				location_name="";
				for(int columnIdx = 0; columnIdx < row.getPhysicalNumberOfCells(); columnIdx++) {
					XSSFCell cell = row.getCell(columnIdx);
					if(cell.getCellType().toString().equals("STRING")) {
						//Cell의 정보가 글씨(지역정보)인 경우에는 location_name 변수에 더해준다.
						location_name += cell.getStringCellValue()+" ";
					} else if(cell.getCellType().toString().equals("NUMERIC")) {
						//Cell의 정보가 숫자일경우에는 지역정보에 넣지 않는다.
						continue;
					}
					arr_location[rowIdx]=location_name; //뺴온 지역 정보를 배열에 하나씩 넣는다.
				}
			}
			
			
			//================ 지역정보를 이용하여 좌표를 구해오기============ 
			ArrayList<String> list_noSearchResult = new ArrayList<>(); // 처리되지 않은 지역을 저장하기 위한 List 
			for(int i = 0; i < arr_location.length; i++) {
				if(i%9==0) {
					//네이버 지역검색 API는 1초당 10개 이상 호출이 불가능하므로,
					//안전하게 9개 검색 후 1초를 쉬는 식으로 진행한다.
					TimeUnit.SECONDS.sleep(1);
				}
				//지역정보 배열의 요소들을 하나씩 빼서 네이버 지역검색 API를 호출한다.
				//지역정보 뒤에 '주민센터'를 붙혀서 검색한다.
				Response<Map<String,Object>> search_result = meetEatService.getLocationInfo(arr_location[i]+"주민센터",null,null).execute();
				@SuppressWarnings("unchecked") ArrayList<Map<String,Object>> list = (ArrayList<Map<String,Object>>) search_result.body().get("items");
				
				if(list!=null&&list.size()!=0) {
					//지역검색 결과의 최상위 노출된 녀셕의 좌표를 얻어온다.
					//해당 좌표는 katec좌표이므로 위도 경도로 변환시켜준다.
					GeoTransPoint katecCoordinate = new GeoTransPoint(Integer.parseInt((String) list.get(0).get("mapx")),Integer.parseInt((String) list.get(0).get("mapy")));
					GeoTransPoint TransforCoordinates = GeoTrans.convert(GeoTrans.KATEC, GeoTrans.GEO, katecCoordinate); //KATEC->위도경도로 변환하는 코드
					
					//지역, 위도, 경도 정보를 테이블에 저장한다. 
					mktViewService.insertCoordinate(arr_location[i],TransforCoordinates.getX(),TransforCoordinates.getY()).execute();
				} else {
					//검색결과가 없는 경우 해당 지역을 List에 넣는다.
					list_noSearchResult.add(arr_location[i]);
				}
				
			}
			System.out.println("아래 지역은 처리되지 않았습니다.");
			for(int i = 0; i < list_noSearchResult.size(); i++) {
				System.out.println(list_noSearchResult.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/coordinate")
	public String getCollect(Model model) {
		return "/locationTest/coordinate";
	}
	
	@PostMapping("/coordinate")
	@ResponseBody
	public Map<String,Object> postParam(
			String query
			, int display
			, int start
			) {
		System.out.printf("display : %d , query : %s, start : %d",display,query,start);
		Map<String,Object> result = new HashMap<>(); 
		return result;
	}
	
}

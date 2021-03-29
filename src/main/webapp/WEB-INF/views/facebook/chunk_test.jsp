<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>청크 업로드 테스트!</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="application/javascript" src="/resources/js/facebook/chunk_test.js" defer></script>
</head>
<body>

<form id="uploadForm" action="/chunk_test" method="POST" enctype="multipart-form-data">
	<input type="file" id="file" name="file"><br>
	<button id="btn_submit"type="button">파일 제출 후 테스트</button>
</form>

</body>
</html>
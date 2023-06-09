<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/jquery.twbsPagination.js" type="text/javascript"></script>
<style></style>
</head>
<body>
${msg}
	<div class="container">
        <form action="class.update.do" method="post">
            <input type="hidden" name="cl_id" value="${dto.cl_id}">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>아이디</label>
                        <input type="text" class="form-control" name="user_id" value="${dto.user_id}">
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" class="form-control" name="cl_subject" value="${dto.cl_subject}">
                    </div>
                    <div class="form-group">
                        <label>사진</label>
                        <div>
                            <c:if test="${dto.photo_name eq null}">
                                <input type="file" class="form-control-file" name="photo">
                            </c:if>
                            <c:if test="${dto.photo_name ne null}">
                                <img src="/photo/${dto.photo_name}" class="img-fluid">
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>모집기간</label>
                        <div>모집 시작일<input type="date" name="cl_period" value="${dto.cl_period}">모집 마감일<input type="date" name="cl_deadlinePeriod" value="${dto.cl_deadlinePeriod}"></div>
                    </div>
                    <div class="form-group">
                        <label>모집인원</label>
                        <input type="text" class="form-control" name="cl_deadline" value="${dto.cl_deadline}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>강사이름</label>
                        <input type="text" class="form-control" name="cl_teacher" value="${dto.cl_teacher}">
                    </div>
                    <div class="form-group">
                        <label>강좌날짜</label>
                        <input type="date" class="form-control" name="cl_date" value="${dto.cl_date}">
                    </div>
                    <div class="form-group">
                        <label>재료여부</label>
                        <div>
                            <c:set var="clContent" value="${dto.cl_ing_chk}" />
                            <c:choose>
                                <c:when test="${clContent eq '0'}">
                                    <input type="radio" name="cl_ing_chk" value="1"> 있음
                                    <input type="radio" name="cl_ing_chk" value="0" checked> 없음
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="cl_ing_chk" value="1" checked> 있음
                                    <input type="radio" name="cl_ing_chk" value="0"> 없음
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>주소</label>
                        <input type="text" id="postcode" name="postcode" class="form-control" placeholder="우편번호" value="${dto.postcode}">                    
                        <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="address" name="address" class="form-control" placeholder="주소" value="${dto.address}"><br>
                        <input type="text" id="detailAddress" name="detailAddress" class="form-control" placeholder="상세주소" value="${dto.detailAddress}"><br>
                        <input type="text" id="extraAddress" name="extraAddress" class="form-control" placeholder="참고항목" value="${dto.extraAddress}">
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" name="cl_content">${dto.cl_content}</textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">저장</button>
                <button type="button" class="btn btn-primary" onclick="location.href='classDel.do?cl_id=${dto.cl_id}'">삭제</button>
                <a href="./classList.go" class="btn btn-secondary">리스트</a>
            </div>
        </form>
    </div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>


</html>
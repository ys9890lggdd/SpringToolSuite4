/**
 * cv
 */
 
 // cv write
 function writeCv() {
	console.log(document.f.cvName.value);
	console.log(document.f.cvDescription.value);
	console.log(document.f.cvPortfolio.value);
	console.log(document.f.userSeq.value);
	if (document.f.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.f.cvName.focus();
		return false;
	}
	if (document.f.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.f.cvDescription.focus();
		return false;
	}
	if (document.f.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.f.cvPortfolio.focus();
		return false;
	}
	document.f.action = "cv-write-action";
	document.f.method='POST';
	document.f.submit();
}

// cv update
function updateCv() {
	console.log('dddddddd');
	console.log(document.f.cvSeq.value);
	console.log(document.f.cvName.value);
	console.log(document.f.cvDescription.value);
	console.log(document.f.cvPortfolio.value);
	console.log(document.f.userSeq.value);
	if (document.f.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.f.cvName.focus();
		return false;
	}
	if (document.f.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.f.cvDescription.focus();
		return false;
	}
	if (document.f.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.f.cvPortfolio.focus();
		return false;
	}
	document.f.action = "cv-update-action";
	document.f.method='POST';
	document.f.submit();
}

// cv delete
function cvDelete() {
	// 나중에 모달 등으로 수정하기
	if (window.confirm("정말 삭제하시겠습니까?")) {
		document.f.method='POST';
		document.f.action = "cv-delete-action";
		document.f.submit();
	}
}

function deleteEdu(eduSeq) {
	$('#eduSeq'+eduSeq).val(eduSeq);
	console.log($('#eduSeq'+eduSeq).attr('value'));
	console.log($('.default-form').serialize());
	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}






/****************** 이하 작업중 */
function addHtml() {
	const addEduBtn = document.getElementById();
}



function addEdu() {

}


function deleteExp(expSeq) {
	$('#expSeq'+expSeq).val(expSeq);
	console.log($('#expSeq'+expSeq).attr('value'));
	console.log($('.default-form').serialize());
}

function deleteEdu(eduSeq) {
	document.f.value=eduSeq;
	$('#eduSeq'+eduSeq).value=eduSeq;
	console.log(document.f.value);
	console.log(">>>>"+$('#eduSeq'+eduSeq).value);

	document.f.action = "info-delete-action";
	document.f.method='POST';
	document.f.submit();
}

// cv apply
function deleteExp() {
	document.f.action = "exp-delete-action";
	document.f.method='GET';
	document.f.submit();
}

function apply() {
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

function changeCv() {
	document.f.action = "cv-detail";
	document.f.method='GET';
	document.f.submit();
}
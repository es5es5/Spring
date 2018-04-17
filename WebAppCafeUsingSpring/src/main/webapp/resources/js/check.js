function drRegCheck() {
	var titleField = document.drRegForm.id_title;
	var fileField = document.drRegForm.id_file;

	if (isEmpty(titleField)) {
		alert("���� Ȯ��");
		titleField.focus();
		return false;
	} else if (isEmpty(fileField)) {
		alert("���� Ȯ��");
		fileField.focus();
		return false;
	}
	return true;
}
function voteRegCheck() {
	var titleField = document.voteRegForm.iv_title;
	var itemsField = document.voteRegForm.iv_items;

	if (isEmpty(titleField)) {
		alert("���� Ȯ��");
		titleField.focus();
		return false;
	} else if (isEmpty(itemsField)) {
		alert("�׸� Ȯ��");
		itemsField.focus();
		return false;
	}
	return true;
}
function writeReplCheck(writeForm) {
	// submit�� ������ form���� isr_txt
	var txtField = writeForm.isr_txt;

	if (isEmpty(txtField)) {
		alert("���� Ȯ��");
		txtField.focus();
		return false;
	}
	return true;
}
function snsSearchCheck() {
	// �� �������� �̸��� snsSearchForm�� form���� is_txt
	var txtField = document.snsSearchForm.is_txt;
	if (isEmpty(txtField)) {
		alert("�Է� Ȯ��");
		txtField.value = "";
		txtField.focus();
		return false;
	}
	return true;
}
function snsWriteCheck() {
	var txtField = document.snsWriteForm.is_txt;
	if (isEmpty(txtField)) {
		alert("�Է� Ȯ��");
		txtField.value = "";
		txtField.focus();
		return false;
	}
	return true;
}
function updateCheck() {
	var idField = document.updateForm.im_id;
	var pwField = document.updateForm.im_pw;
	var pwChkField = document.updateForm.im_pwChk;
	var nameField = document.updateForm.im_name;
	var addr3Field = document.updateForm.im_addr3;
	var imgField = document.updateForm.im_img;

	if (isEmpty(idField) || containsHangul(idField)) {
		alert("id Ȯ��");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || notEquals(pwField, pwChkField)
			|| lessThan(pwField, 4) || notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("pw Ȯ��");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(nameField)) {
		alert("�̸� Ȯ��");
		nameField.value = "";
		nameField.focus();
		return false;
	} else if (isEmpty(addr3Field)) {
		alert("�ּ� Ȯ��");
		addrField3.value = "";
		addrField3.focus();
		return false;
	} else if (isEmpty(imgField)) {
		return true;
	} else if (isNotType(imgField, ".png") && isNotType(imgField, ".gif")
			&& isNotType(imgField, ".jpg") && isNotType(imgField, ".bmp")) {
		alert("���� Ȯ���� Ȯ��");
		imgField.value = "";
		imgField.focus();
		return false;
	}
	return true;
}
function joinCheck() {
	var idField = document.joinForm.im_id;
	var pwField = document.joinForm.im_pw;
	var pwChkField = document.joinForm.im_pwChk;
	var nameField = document.joinForm.im_name;
	var addr1Field = document.joinForm.im_addr1;
	var addr2Field = document.joinForm.im_addr2;
	var addr3Field = document.joinForm.im_addr3;
	var imgField = document.joinForm.im_img;

	if (isEmpty(idField) || containsHangul(idField)) {
		alert("id Ȯ��");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || notEquals(pwField, pwChkField)
			|| lessThan(pwField, 4) || notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("pw Ȯ��");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(nameField)) {
		alert("�̸� Ȯ��");
		nameField.value = "";
		nameField.focus();
		return false;
	} else if (isEmpty(addr1Field) || isEmpty(addr2Field) || isEmpty(addr3Field)) {
		alert("�ּ� Ȯ��");
		addr1Field.value = "";
		addr2Field.value = "";
		addr3Field.value = "";
		addr3Field.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif")
					&& isNotType(imgField, ".jpg") && isNotType(imgField,
					".bmp"))) {
		alert("���� Ȯ��");
		imgField.value = "";
		imgField.focus();
		return false;
	}
	return true;
}
function loginCheck() {
	var idField = document.loginForm.im_id;
	var pwField = document.loginForm.im_pw;

	if (isEmpty(idField)) {
		alert("id Ȯ��");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField)) {
		alert("pw Ȯ��");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}
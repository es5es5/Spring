function bye(im_id) {
	var ok = confirm("Å»ÅðÇÒ°ÅÀÓ?");
	if (ok) {
		location.href = "bye.do?im_id="+im_id;
	}
}

function deleteData(id_id, id_file) {
	var ok = confirm("ÁøÂ¥?");
	if (ok) {
		location.href = "DataRoomDeleteController?id_id=" + id_id + "&id_file=" + id_file;
	}
}
function deleteMsg(im_no) {
	var ok = confirm("?");
	if (ok) {
		location.href = "MsgDeleteController?im_no=" + im_no;
	}
}

function deleteRepl(isr_no) {
	var ok = confirm("");
	if (ok) {
		location.href = "SNSReplDeleteController?isr_no=" + isr_no;
	}
}

function deleteSNS(is_no) {
	var ok = confirm("");
	if (ok) {
		location.href = "SNSDeleteController?is_no=" + is_no;
	}
}

function goJoin() {
	location.href = "join.go";
}

function goUpdateMember() {
	location.href = "MemberUpdateController";
}

function logout() {
	var ok = confirm("ÁøÂ¥?");
	if (ok) {
		location.href = "logout.do";
	}
}

function searchSNS(is_owner) {
	location.href = "SNSSearchController?is_owner=" + is_owner;
}

function sendMsg(im_to) {
	var im_txt = prompt(im_to);

	if (im_txt != null && im_txt != "" && im_txt.length <= 150) {
		location.href = "MsgSendController?im_to=" + im_to + "&im_txt="
				+ im_txt;
	}
}

function updateSNS(is_no) {
	var is_txt = prompt("");

	if (is_txt != null && is_txt != "" && is_txt.length <= 150) {
		location.href = "SNSUpdateController?is_no=" + is_no + "&is_txt="
				+ is_txt;
	}
}

function goUpdateMember(){
	location.href = "member.update.go";
}


/**
 * 프로젝트에 사용될 common js
 */

//출처: http://cofs.tistory.com/363 [CofS]
//cookie 기본 유효기간은 1일
function setCookie(name, value , day){
	var date = new Date();
    date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
    document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
}
//expires 확인 되나??
function getCookie(name){
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}

function deleteCookie(name){
	var date = new Date();
    document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/"
}

function leftTrim(str) {
	return str.replace(/^\s+/,"");	
}

function rightTrim(str) {
	return str.replace(/\s+$/,"");
}

function sideTrim(str) {
	return str.replace(/^\s+|\s+$/g,"");
}

function perfectTrim(str) {
	return str.replace(/(\s*)/g,"");
}


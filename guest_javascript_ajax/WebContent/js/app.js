import * as View from "./view.js";
//import {render as Render} from "./view.js";
//import {render } from "./view.js";
/*
메뉴객체이벤트등록
*/
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');
/*
   #guest-detail-template
   #guest-main-template
   #guest-write-template
   #guest-modify-template
   #guest-list-template
*/
menuGuestHome.addEventListener('click',function(e){
	View.render("#guest-main-template",{},"#content");
	e.preventDefault();
	
});
menuGuestList.addEventListener('click', function(e){
	View.render("#guest-list-template",{},"#content");
	e.preventDefault();
});
menuGuestWriteForm.addEventListener('click', function(e) {
    View.render("#guest-write-form-template",{},"#content");
	e.preventDefault();
});
/*
초기로딩시에 home anchor click event trigger
*/
//menuGuestHome.click();




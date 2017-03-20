// JavaScript Document
window.onload=function(){
	var nav=document.getElementById("nav");
	var items=nav.getElementsByTagName("li");
	for(var i=0;i<items.length;i++){
		var item=items[i];
		item.onmouseover=function(){
			this.style.backgroundColor="#DAEDF5";
			this.style.color="#5288b6";
		}
		item.onmouseout=function(){
			this.style.backgroundColor="#5288b6";
			this.style.color="#DAEDF5";
		}
		item.onclick=function(){
			location.href=this.getAttribute("link");
		}
	}
}

function inputFocus(el){
	if(el.value==el.title){
		el.value="";
	}
}

function inputBlur(el){
	if(el.value==""){
		el.value=el.title;
	}
}
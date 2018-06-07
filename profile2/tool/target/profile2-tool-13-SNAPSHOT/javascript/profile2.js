function getScroll(){if(document.all){return top.document.documentElement.scrollTop
}else{return top.pageYOffset
}}function fixWindowVertical(){var b=Wicket.Window.get();
if(b){var a=getScroll()+50;
b.window.style.top=a+"px"
}return false
}function resizeFrame(b){if(top.location!=self.location){try{if(parent.document){var d=parent.document.getElementById(window.name)
}}catch(c){return
}}if(d){if(b=="shrink"){var a=document.body.clientHeight
}else{var a=document.body.clientHeight+400
}$(d).height(a)
}else{}}$(document).ready(function(){$(".edit-image-button").focus(function(){$(this).removeClass("offscreen")
});
$(".edit-image-button").blur(function(){$(this).addClass("offscreen")
});
$(".edit-button").focus(function(){$(this).removeClass("offscreen")
});
$(".edit-button").blur(function(){$(this).addClass("offscreen")
});
$(".sakai-wicket-iconwithtooltip").qtip()
});
function doUpdateCK(){for(instance in CKEDITOR.instances){CKEDITOR.instances[instance].updateElement()
}};
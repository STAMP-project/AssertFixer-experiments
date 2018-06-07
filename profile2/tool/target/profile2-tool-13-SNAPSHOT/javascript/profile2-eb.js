var CONNECTION_NONE=0;
var CONNECTION_REQUESTED=1;
var CONNECTION_INCOMING=2;
var CONNECTION_CONFIRMED=3;
function friendStatus(c,b){var a=null;
jQuery.ajax({url:"/direct/profile/"+c+"/friendStatus.json?friendId="+b,dataType:"json",async:false,cache:false,success:function(d){a=d.data
},error:function(){a=-1
}});
return a
}function requestFriend(b,a){jQuery.ajax({url:"/direct/profile/"+b+"/requestFriend?friendId="+a,dataType:"text",cache:false,success:function(d,c){var e=$("#profile_friend_"+a);
e.html(d);
e.attr("class","icon connection-request")
}});
return false
}function confirmFriendRequest(b,a){jQuery.ajax({url:"/direct/profile/"+b+"/confirmFriendRequest?friendId="+a,dataType:"text",cache:false,success:function(e,c){var d='<a href="javascript:;" onClick="return removeFriend(\''+b+"','"+a+"');\">"+e+"</a>";
var f=$("#profile_friend_"+a);
f.html(d);
f.attr("class","icon connection-confirmed")
}});
return false
}function removeFriend(a,b){jQuery.ajax({url:"/direct/profile/"+a+"/removeFriend?friendId="+b,dataType:"text",cache:false,success:function(e,c){var d='<a href="javascript:;" onClick="return requestFriend(\''+a+"','"+b+"');\">"+e+"</a>";
var f=$("#profile_friend_"+b);
f.html(d);
f.attr("class","icon connection-add")
}});
return false
}function ignoreFriendRequest(a,b){jQuery.ajax({url:"/direct/profile/"+a+"/ignoreFriendRequest?friendId="+b,dataType:"text",cache:false,success:function(e,c){var d='<a href="javascript:;" onClick="return requestFriend(\''+a+"','"+b+"');\">"+e+"</a>";
var f=$("#profile_friend_"+b);
f.html(d);
f.attr("class","icon connection-add")
}});
return false
};
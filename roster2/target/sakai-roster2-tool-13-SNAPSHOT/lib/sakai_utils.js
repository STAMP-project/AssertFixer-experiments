(function(a){roster.sakai={setCurrentUserPermissions:function(b,c){a.ajax({url:"/direct/site/"+b+"/userPerms.json",dataType:"json",cache:false,success:function(e,d){roster.currentUserPermissions=new roster.RosterPermissions(e.data);
c()
},error:function(f,e,d){alert("Failed to get the current user permissions. Status: "+e+". Error: "+d)
}})
},getSitePermissionMatrix:function(b,c){a.ajax({url:"/direct/site/"+b+"/perms/roster.json",dataType:"json",cache:false,success:function(d){c(d.data)
},error:function(f,e,d){alert("Failed to get permissions. Status: "+e+". Error: "+d)
}})
},savePermissions:function(h,e,k){var d=a("."+e);
var g={};
for(var c=0,b=d.length;
c<b;
c++){var f=d[c];
if(f.checked){g[f.id]="true"
}else{g[f.id]="false"
}}a.ajax({url:"/direct/site/"+h+"/setPerms",type:"POST",data:g,timeout:30000,dataType:"text",success:function(i){k()
},error:function(l,i,j){alert("Failed to save permissions. Status: "+i+". Error: "+j)
}})
}}
})(jQuery);
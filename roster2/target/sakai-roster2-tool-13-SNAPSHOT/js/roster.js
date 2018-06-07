(function(a){roster.setupPrintButton=function(){a(".roster-print-button").click(function(c){var b=a(this);
b.prop("disabled",true);
c.preventDefault();
roster.renderMembership({renderAll:true,callback:function(){var d=roster.picturesMode?a("#roster-members-content"):a("#roster-members");
d.waitForImages(function(){b.prop("disabled",false);
window.print()
})
}})
})
};
roster.setupPicturesButton=function(){var b=a("#roster-pictures-only-button");
if(roster.picturesMode){b.prop("checked",true)
}b.click(function(c){if(this.checked){roster.picturesMode=true;
roster.renderMembership({renderAll:true})
}else{roster.picturesMode=false;
roster.renderMembership({replace:true})
}})
};
roster.checkScroll=function(){if(a("body").height()<=a(window).height()){setTimeout(function(){var b=a(".roster-member").size();
if(roster.site.membersTotal>b&&b>0&&b%roster.pageSize===0){a("body").data("scroll-roster",true);
a(window).trigger("scroll.roster")
}},100)
}};
roster.render=function(d,e,b){var c=Handlebars.templates[d];
document.getElementById(b).innerHTML=c(e)
};
roster.switchState=function(c,b){roster.currentState=c;
a("#roster_navbar > li > span").removeClass("current");
if(c!==roster.STATE_PERMISSIONS){roster.rosterLastStateNotPermissions=c
}if(roster.showPermsToMaintainers){a("#navbar_permissions_link").show()
}else{a("#navbar_permissions_link").hide()
}if(!roster.currentUserPermissions.viewEnrollmentStatus||roster.site.siteEnrollmentSets.length===0){a("#navbar_enrollment_status_link").hide();
if(roster.STATE_ENROLLMENT_STATUS===c){c=roster.DEFAULT_STATE
}}if(roster.STATE_OVERVIEW===c){roster.enrollmentSetToView=null;
roster.enrollmentStatus="all";
roster.groupToView=(b&&b.group)?b.group:null;
roster.nextPage=0;
a("#navbar_overview_link > span").addClass("current");
a("#roster_header").html("");
a("#roster_section_filter").html("");
a("#roster_search").html("");
roster.render("overview",{siteGroups:roster.site.siteGroups,membersTotal:roster.i18n.currently_displaying_participants.replace(/\{0\}/,roster.site.membersTotal),roleFragments:roster.getRoleFragments(roster.site.roleCounts),roles:roster.site.userRoles,checkOfficialPicturesButton:roster.officialPictureMode,viewGroup:roster.currentUserPermissions.viewGroup,viewOfficialPhoto:roster.currentUserPermissions.viewOfficialPhoto},"roster_content");
a(document).ready(function(){if(b&&b.group){a("#roster-group-option-"+b.group).prop("selected",true)
}roster.addExportHandler();
a("#roster-groups-selector-top").change(function(d){if(this.value==="all"){roster.groupToView=null;
roster.renderMembership({replace:true})
}else{roster.renderGroupMembership(this.value)
}});
a("#roster-roles-selector").change(function(d){if(this.value==="all"){roster.roleToView=null
}else{roster.roleToView=this.value
}roster.renderMembership({replace:true})
});
roster.setupPrintButton();
roster.setupPicturesButton();
if(roster.currentUserPermissions.viewOfficialPhoto){a("#roster_official_picture_button").click(function(d){roster.officialPictureMode=true;
roster.renderMembership({replace:true})
});
a("#roster_profile_picture_button").click(function(d){roster.officialPictureMode=false;
roster.renderMembership({replace:true})
})
}roster.readySearchButton();
roster.readySearchField();
roster.readyClearButton(c);
a("#navbar_overview_link > span > a").off("click");
roster.renderMembership({replace:true})
});
a(window).off("scroll.roster").on("scroll.roster",roster.getScrollFunction({}))
}else{if(roster.STATE_ENROLLMENT_STATUS===c){roster.nextPage=0;
roster.groupToView=null;
a("#navbar_enrollment_status_link > span").addClass("current");
if(null===roster.enrollmentSetToView&&null!=roster.site.siteEnrollmentSets[0]){roster.enrollmentSetToView=roster.site.siteEnrollmentSets[0].id;
roster.groupToView=null
}roster.render("enrollment_overview",{enrollmentSets:roster.site.siteEnrollmentSets,onlyOne:roster.site.siteEnrollmentSets.length==1,enrollmentStatusCodes:roster.site.enrollmentStatusCodes,viewOfficialPhoto:roster.currentUserPermissions.viewOfficialPhoto},"roster_content");
a(document).ready(function(){roster.addExportHandler();
a("#roster-enrollmentset-selector").change(function(f){var d=this.options[this.selectedIndex];
roster.enrollmentSetToView=d.value;
roster.enrollmentSetToViewText=d.text;
roster.renderMembership({replace:true})
});
a("#roster-status-selector").change(function(d){roster.enrollmentStatus=this.value;
if(roster.enrollmentStatus==""){roster.enrollmentStatus="all"
}roster.renderMembership({replace:true})
});
roster.setupPrintButton();
roster.setupPicturesButton();
if(roster.currentUserPermissions.viewOfficialPhoto){a("#roster_official_picture_button").click(function(d){roster.officialPictureMode=true;
roster.renderMembership({replace:true})
});
a("#roster_profile_picture_button").click(function(d){roster.officialPictureMode=false;
roster.renderMembership({replace:true})
})
}roster.readySearchButton();
roster.readySearchField();
roster.readyClearButton(c);
a("#navbar_enrollment_status_link").off("click");
roster.renderMembership({replace:true})
})
}else{if(roster.STATE_PERMISSIONS===c){a("#navbar_permissions_link > span").addClass("current");
a("#roster_section_filter").html("");
a("#roster_search").html("");
roster.sakai.getSitePermissionMatrix(roster.siteId,function(e){roster.site.permissions=e;
var d=Object.keys(e).map(function(f){return{name:f}
});
roster.render("permissions",{siteTitle:roster.site.title,showVisits:roster.showVisits,roles:d},"roster_content");
a(document).ready(function(){a("#roster_permissions_save_button").click(function(){roster.sakai.savePermissions(roster.siteId,"roster_permission_checkbox",function(){window.location.reload()
})
});
a("#roster_cancel_button").click(function(){roster.switchState(roster.rosterLastStateNotPermissions)
})
})
})
}}}};
roster.renderGroupMembership=function(b){if(b===roster.DEFAULT_GROUP_ID){b=null
}a("#roster-search-field").val("");
roster.groupToView=b;
roster.renderMembership({replace:true})
};
roster.renderMembership=function(d){var c=roster.currentState==roster.STATE_ENROLLMENT_STATUS;
if(roster.picturesMode){d.renderAll=true;
d.replace=true
}if(d.replace){a("#roster-members").empty();
roster.nextPage=0;
if(!roster.picturesMode){roster.render("members_header",{viewEmail:roster.viewEmail,viewUserDisplayId:roster.viewUserDisplayId,viewUserProperty:roster.viewUserProperty,viewProfile:roster.currentUserPermissions.viewProfile,viewGroup:roster.currentUserPermissions.viewGroup,viewPicture:true,viewSiteVisits:roster.currentUserPermissions.viewSiteVisits,viewConnections:((undefined!=window.friendStatus)&&roster.viewConnections),enrollmentsMode:c,showVisits:roster.showVisits,},"roster-members-content")
}a(window).off("scroll.roster")
}if(d.renderAll){a("#roster-members").empty();
a(window).off("scroll.roster")
}var b="/direct/roster-membership/"+roster.siteId;
if(d.userIds){b+="/get-users.json?userIds="+d.userIds.join(",");
if(roster.enrollmentSetToView){b+="&enrollmentSetId="+roster.enrollmentSetToView
}}else{b+="/get-membership.json?";
if(d.renderAll){b+="all=true"
}else{b+="page="+roster.nextPage
}if(roster.groupToView){b+="&groupId="+roster.groupToView
}else{if(roster.enrollmentSetToView){b+="&enrollmentSetId="+roster.enrollmentSetToView
}}if(roster.roleToView){b+="&roleId="+encodeURIComponent(roster.roleToView)
}}if(roster.enrollmentStatus){b+="&enrollmentStatus="+roster.enrollmentStatus
}var e=a("#roster-loading-image");
e.show();
a.ajax({url:b,dataType:"json",cache:false,success:function(i){if(i.status&&i.status==="END"){e.hide();
if(roster.nextPage===0){var h=roster.i18n.currently_displaying_participants.replace(/\{0\}/,0);
a("#roster-members-total").html(h);
a("#roster-role-totals").html("")
}return
}var f=i.members;
roster.pageSize=(i.pageSize!=undefined)?i.pageSize:10;
if(roster.nextPage===0){var h=roster.i18n.currently_displaying_participants.replace(/\{0\}/,i.membersTotal);
a("#roster-members-total").html(h);
var g=roster.getRoleFragments(i.roleCounts);
a("#roster-role-totals").html(g)
}f.forEach(function(k){k.profileImageUrl="/direct/profile/"+k.userId+"/image";
if(roster.officialPictureMode){k.profileImageUrl+="/official"
}k.profileImageUrl+="?siteId="+encodeURIComponent(roster.siteId);
var l=Object.keys(k.groups);
k.hasGroups=l.length>0;
var j=l.map(function(m){return{id:m,title:k.groups[m]}
});
k.groups=j;
if(roster.showVisits){if(k.totalSiteVisits>0){k.formattedLastVisitTime=roster.formatDate(k.lastVisitTime)
}else{k.formattedLastVisitTime=roster.i18n.no_visits_yet
}}});
if(roster.picturesMode){roster.renderPictures(f,a("#roster-members-content"),c)
}else{roster.renderMembers(f,a("#roster-members"),c)
}a(document).ready(function(){roster.alignMobileLabels();
a(".roster-group-link").click(function(k){var j=a(this).attr("data-groupid");
if(roster.currentState===roster.STATE_ENROLLMENT_STATUS){roster.switchState(roster.STATE_OVERVIEW,{group:j})
}else{a("#roster-group-option-"+j).prop("selected",true);
roster.renderGroupMembership(j)
}});
profile.attachPopups(a("a.profile"));
if(roster.nextPage===0||d.renderAll){if(roster.currentState===roster.STATE_OVERVIEW){a("#navbar_overview_link > span > a").off("click").on("click",function(j){return roster.switchState(roster.STATE_OVERVIEW)
})
}else{if(roster.currentState===roster.STATE_ENROLLMENT_STATUS){a("#navbar_enrollment_status_link > span > a").off("click").on("click",function(j){return roster.switchState(roster.STATE_ENROLLMENT_STATUS)
})
}}}if(d.userIds){a(window).off("scroll.roster")
}else{if(!d.renderAll){roster.nextPage+=1;
a(window).off("scroll.roster").on("scroll.roster",roster.getScrollFunction({enrollmentsMode:c}))
}}e.hide();
if(d.callback){d.callback()
}})
},error:function(f,h,g){console.log("Failed to get membership data. textStatus: "+h+". errorThrown: "+g)
}})
};
roster.readyClearButton=function(b){a("#roster_form_clear_button").click(function(c){roster.roleToView=null;
roster.switchState(b)
})
};
roster.search=function(c){if(c!==roster.i18n.roster_search_text&&c!==""){var d=[];
var b=roster.searchIndex[c];
if(!b){roster.searchIndexKeys.forEach(function(e){var f=new RegExp(c,"i");
if(f.test(e)){d.push(roster.searchIndex[e])
}});
if(d.length>5){d=d.slice(0,5)
}}else{d.push(b)
}if(d.length>0){roster.renderMembership({replace:true,userIds:d})
}else{a("#roster-members").html('<div id="roster-information">'+roster.i18n.no_participants+"</div>");
a("#roster-members-total").hide();
a("#roster_type_selector").hide();
a("#summary").hide()
}}};
roster.readySearchButton=function(){a("#roster-search-button").off("click").on("click",function(b){var c=a("#roster-search-field").val();
roster.search(c)
})
};
roster.readySearchField=function(){var b=a("#roster-search-field");
b.keydown(function(c){if(c.which==13){c.preventDefault();
a("#roster-search-button").click()
}});
b.autocomplete({source:roster.searchIndexKeys,select:function(c,d){roster.search(d.item.value)
}})
};
roster.renderMembers=function(b,f,c,g){var e={members:b,groupToView:roster.groupToView,firstNameLastName:roster.firstNameLastName,viewEmail:roster.viewEmail,viewUserDisplayId:roster.viewUserDisplayId,viewUserProperty:roster.viewUserProperty,viewProfile:roster.currentUserPermissions.viewProfile,viewGroup:roster.currentUserPermissions.viewGroup,viewPicture:true,currentUserId:roster.userId,viewOfficialPhoto:roster.currentUserPermissions.viewOfficialPhoto,enrollmentsMode:c,viewSiteVisits:roster.currentUserPermissions.viewSiteVisits,viewConnections:((undefined!=window.friendStatus)&&roster.viewConnections),showVisits:roster.showVisits};
if(!g){a(window).off("scroll.roster.rendered").on("scroll.roster.rendered",roster.checkScroll)
}var d=Handlebars.templates.members;
f.append(d(e));
if(!g){a(window).trigger("scroll.roster.rendered")
}};
roster.renderPictures=function(b,f,c,g){var e={members:b,groupToView:roster.groupToView,firstNameLastName:roster.firstNameLastName,viewProfile:roster.currentUserPermissions.viewProfile,viewPicture:true,currentUserId:roster.userId,viewOfficialPhoto:roster.currentUserPermissions.viewOfficialPhoto,enrollmentsMode:c};
var d=Handlebars.templates.pictures;
f.html(d(e))
};
roster.getScrollFunction=function(c){var b=function(){var e=a(window).scrollTop(),f=a(document).height(),d=a(window).height();
if((e/(f-d))>0.95||a("body").data("scroll-roster")===true){a("body").data("scroll-roster",false);
a(window).off("scroll.roster");
roster.renderMembership(c)
}};
return b
};
roster.getRoleFragments=function(b){return Object.keys(b).map(function(c){var d=roster.i18n.role_breakdown_fragment.replace(/\{0\}/,b[c]);
return d.replace(/\{1\}/,'<span class="role">'+c+"</span>")
}).join(", ")
};
roster.formatDate=function(e){var f=new Date(e);
var b=f.getHours();
if(b<10){b="0"+b
}var c=f.getMinutes();
if(c<10){c="0"+c
}return f.getDate()+" "+roster.i18n.months[f.getMonth()]+" "+f.getFullYear()+" @ "+b+":"+c
};
roster.addExportHandler=function(){var b=a("#roster-export-button");
if(!roster.currentUserPermissions.rosterExport){b.hide()
}else{b.show();
a("#roster-export-button").click(function(f){f.preventDefault();
var d="/direct/roster-export/"+roster.siteId+"/export-to-excel?viewType="+roster.currentState;
if(roster.STATE_OVERVIEW===roster.currentState){var c=null;
if(null!=roster.groupToView){c=roster.groupToView
}else{c=roster.DEFAULT_GROUP_ID
}if(null!=roster.roleToView){d+="&roleId="+roster.roleToView
}window.location.href=d+"&groupId="+c
}else{if(roster.STATE_ENROLLMENT_STATUS===roster.currentState){window.location.href=d+"&enrollmentSetId="+roster.enrollmentSetToView+"&enrollmentStatus="+roster.enrollmentStatus
}}})
}};
if(!roster.siteId){alert("The site id  MUST be supplied as a bootstrap parameter.");
return
}if(!roster.userId){alert("No current user. Have you logged in?");
return
}Handlebars.registerHelper("translate",function(b){return roster.i18n[b]
});
Handlebars.registerHelper("getName",function(b){return(b)?this.displayName:this.sortName
});
Handlebars.registerHelper("roleAllowed",function(b){var c=b.hash.permission;
var d=this.name;
return roster.site.permissions[d].indexOf(c)!=-1
});
roster.init=function(){roster.i18n=a.i18n.map;
roster.i18n.months=roster.i18n.months.split(",");
roster.ADMIN="admin";
roster.STATE_OVERVIEW="overview";
roster.STATE_ENROLLMENT_STATUS="status";
roster.STATE_PRINT="print";
roster.STATE_PERMISSIONS="permissions";
roster.DEFAULT_GROUP_ID="all";
roster.DEFAULT_ENROLLMENT_STATUS="All";
roster.DEFAULT_STATE=roster.STATE_OVERVIEW;
roster.language=null;
roster.rosterLastStateNotPermissions=null;
roster.hideNames=false;
roster.viewSingleColumn=false;
roster.groupToView=null;
roster.groupToViewText=roster.i18n.roster_sections_all;
roster.enrollmentSetToView=null;
roster.enrollmentSetToViewText=null;
roster.enrollmentStatusToViewText=roster.i18n.roster_enrollment_status_all;
roster.nextPage=0;
roster.currentState=null;
roster.render("navbar",{},"roster_navbar");
a("#navbar_overview_link > span > a").click(function(b){return roster.switchState(roster.STATE_OVERVIEW)
});
a("#navbar_enrollment_status_link > span > a").on("click",function(b){return roster.switchState(roster.STATE_ENROLLMENT_STATUS)
});
a("#navbar_print_link > span > a").click(function(b){return roster.switchState(roster.STATE_PRINT)
});
a("#navbar_permissions_link > span > a").click(function(b){return roster.switchState(roster.STATE_PERMISSIONS)
});
if(!roster.currentUserPermissions.viewOfficialPhoto){roster.officialPictureMode=false
}a.ajax({url:"/direct/roster-membership/"+roster.siteId+"/get-search-index.json",dataType:"json",success:function(b){roster.searchIndex=b.data;
roster.searchIndexKeys=Object.keys(b.data);
roster.switchState(roster.state,roster)
},error:function(){}})
};
roster.loadSiteDataAndInit=function(){a.ajax({url:"/direct/roster-membership/"+roster.siteId+"/get-site.json",dataType:"json",cache:false,success:function(b){roster.site=b||{};
if(!roster.site.siteGroups){roster.site.siteGroups=[]
}if(!roster.site.userRoles){roster.site.userRoles=[]
}if(!roster.site.siteEnrollmentSets){roster.site.siteEnrollmentSets=[]
}if(roster.userId===roster.ADMIN){var b=["roster.export","roster.viewallmembers","roster.viewenrollmentstatus","roster.viewgroup","roster.viewhidden","roster.viewprofile","site.upd"];
roster.currentUserPermissions=new roster.RosterPermissions(b);
roster.init()
}else{roster.sakai.setCurrentUserPermissions(roster.siteId,function(){roster.init()
})
}}})
};
a.i18n.properties({name:"ui",path:"/sakai-roster2-tool/i18n/",mode:"both",async:true,checkAvailableLanguages:true,language:roster.language,callback:function(){roster.loadSiteDataAndInit()
}});
roster.alignMobileLabels=function(){if(!roster.maxMobileLabelWidth){roster.maxMobileLabelWidth=0;
a(".roster-mobile-label").each(function(b){var c=a(this).width();
if(c>roster.maxMobileLabelWidth){roster.maxMobileLabelWidth=c
}})
}a(".roster-mobile-label").width(roster.maxMobileLabelWidth)
};
a(window).resize(function(){roster.alignMobileLabels()
})
})(jQuery);
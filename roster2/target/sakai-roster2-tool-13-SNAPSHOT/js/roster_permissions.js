roster.RosterPermissions=function(b){var a=this;
b.forEach(function(c){if("roster.export"===c){a.rosterExport=true
}else{if("roster.viewallmembers"===c){a.viewAllMembers=true
}else{if("roster.viewenrollmentstatus"===c){a.viewEnrollmentStatus=true
}else{if("roster.viewgroup"===c){a.viewGroup=true
}else{if("roster.viewhidden"===c){a.viewHidden=true
}else{if("roster.viewprofile"===c){a.viewProfile=true
}else{if("roster.viewofficialphoto"===c){a.viewOfficialPhoto=true
}else{if("roster.viewsitevisits"===c){a.viewSiteVisits=true
}else{if("roster.viewemail"===c){a.viewEmail=true
}else{if("site.upd"===c){a.siteUpdate=true
}}}}}}}}}}})
};
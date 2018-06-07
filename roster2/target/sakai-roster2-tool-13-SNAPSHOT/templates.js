(function () {
// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/enrollment_header.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "<table class=\"rosterPageHeader\">\n	<tbody>\n		<tr>\n			<td class=\"rosterPageHeaderLeft\">\n				<h3>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"title_status",{"name":"translate","hash":{},"data":data}))
    + ": "
    + container.escapeExpression(((helper = (helper = helpers.siteTitle || (depth0 != null ? depth0.siteTitle : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"siteTitle","hash":{},"data":data}) : helper)))
    + "</h3>\n			</td>\n			<td class=\"rosterPageHeaderRight\">\n				<input id=\"export_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"export_roster",{"name":"translate","hash":{},"data":data}))
    + "\"/>\n				<input type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"print_roster",{"name":"translate","hash":{},"data":data}))
    + "\" onclick=\"window.print()\" />\n			</td>\n		</tr>\n	</tbody>\n</table>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['enrollment_header'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['enrollment_header'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/enrollment_overview.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.displayTitleMsg : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "<div id=\"roster-filters\">\n    <div class=\"form-group\" id=\"roster-set-selector-wrapper\">\n        <label for=\"roster-enrollmentset-selector\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"enrollment_set_filter_label",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div>\n            <select id=\"roster-enrollmentset-selector\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentSets : depth0),{"name":"each","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </select>\n        </div>\n    </div>\n    <div class=\"form-group\" id=\"roster-status-selector-wrapper\">\n        <label for=\"roster-status-selector\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"enrollment_status_filter_label",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div class=\"roster-table-cell\">\n            <select id=\"roster-status-selector\">\n                <option selected=\"selected\" value=\"\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_enrollment_status_all",{"name":"translate","hash":{},"data":data}))
    + "</option>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentStatusCodes : depth0),{"name":"each","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </select>\n        </div>\n    </div>\n    <button id=\"roster-export-button\" title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_export_tooltip",{"name":"translate","hash":{},"data":data}))
    + "\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_export",{"name":"translate","hash":{},"data":data}))
    + "</button>\n</div>\n\n<div id=\"roster-search-group\">\n    <div class=\"form-group\">\n        <label for=\"roster-search-field\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_text",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div>\n            <input id=\"roster-search-field\" type=\"text\" value=\""
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.searchQuery : depth0),{"name":"if","hash":{},"fn":container.program(7, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" />\n            <input id=\"roster-search-button\" class=\"active\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_button",{"name":"translate","hash":{},"data":data}))
    + "\" />\n            <input id=\"roster_form_clear_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_clear_button",{"name":"translate","hash":{},"data":data}))
    + "\" />		\n        </div>	\n     </div>\n</div>\n\n<div id=\"roster_type_selector\" class=\"row\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewOfficialPhoto : depth0),{"name":"if","hash":{},"fn":container.program(9, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</div>\n<div class=\"row\">\n    <div class=\"form-group col-sm-6\">\n        <button class=\"roster-print-button\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"print_roster",{"name":"translate","hash":{},"data":data}))
    + "</button>\n        <label id=\"roster-pictures-only-label\">\n            <input type=\"checkbox\" id=\"roster-pictures-only-button\" />\n            "
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"pictures_only",{"name":"translate","hash":{},"data":data}))
    + "\n        </label>\n    </div>\n</div>\n<div id=\"roster-members-content\"></div>\n<div id=\"roster-loading-image\"><img src=\"/sakai-roster2-tool/images/ajax-loader.gif\" /></div>\n<div class=\"row\">\n    <div class=\"form-group col-sm-6\">\n        <button class=\"roster-print-button\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"print_roster",{"name":"translate","hash":{},"data":data}))
    + "</button>\n    </div>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    return "	<span class=\"instruction rosterTitleMessage\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"title_msg",{"name":"translate","hash":{},"data":data}))
    + "</span>\n";
},"3":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <option value=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"title","hash":{},"data":data}) : helper)))
    + "</option>\n";
},"5":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <option value=\""
    + container.escapeExpression(((helper = (helper = helpers.key || (data && data.key)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"key","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</option>\n";
},"7":function(container,depth0,helpers,partials,data) {
    var helper;

  return container.escapeExpression(((helper = (helper = helpers.searchQuery || (depth0 != null ? depth0.searchQuery : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"searchQuery","hash":{},"data":data}) : helper)));
},"9":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    <div class=\"form-inline\">\n        <div class=\"form-group\">\n            <div class=\"radio\">\n                <label style=\"margin-right: 1em;\">\n                    <input style=\"margin-right: 0.5em;\" type=\"radio\" name=\"roster_picture_type\" value=\"official\" id=\"roster_official_picture_button\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},((stack1 = (depth0 != null ? depth0.roster : depth0)) != null ? stack1.rosterOfficialPictureMode : stack1),{"name":"if","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "/><span>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_show_official_pictures",{"name":"translate","hash":{},"data":data}))
    + "</span>\n                </label>\n            </div>\n        </div>\n        <div class=\"form-group\">\n            <div class=\"radio\">\n                <label style=\"margin-right: 1em;\">\n                    <input style=\"margin-right: 0.5em;\" type=\"radio\" name=\"roster_picture_type\" value=\"profile\" id=\"roster_profile_picture_button\" "
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},((stack1 = (depth0 != null ? depth0.roster : depth0)) != null ? stack1.rosterOfficialPictureMode : stack1),{"name":"unless","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "/><span>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_show_profile_pictures",{"name":"translate","hash":{},"data":data}))
    + "</span>\n                </label>\n            </div>\n        </div>\n    </div>\n";
},"10":function(container,depth0,helpers,partials,data) {
    return "checked";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['enrollment_overview'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['enrollment_overview'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/enrollment_section_filter.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<table>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentSets : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</table>\n";
},"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "	<tbody>\n		<tr>\n			<td><span class=\"filterLabel\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"enrollment_status_filter",{"name":"translate","hash":{},"data":data}))
    + "</span></td>\n			<td>\n				<span>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.onlyOne : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.program(4, data, 0),"data":data})) != null ? stack1 : "")
    + "				</span>\n			</td>\n		</tr>\n		<tr>\n			<td><span class=\"filterLabel\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"enrollment_status_filter_label",{"name":"translate","hash":{},"data":data}))
    + "</span></td>\n			<td><span class=\"filterElement\">\n					<select id=\"roster_form_enrollment_status_filter\" size=\"1\">\n						<option selected=\"selected\" value=\"\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_enrollment_status_all",{"name":"translate","hash":{},"data":data}))
    + "</option>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentStatusDescriptions : depth0),{"name":"each","hash":{},"fn":container.program(7, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "					</select>\n				</span>\n			</td>\n		</tr>\n	</tbody>\n";
},"2":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "						"
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.enrollmentSets : depth0)) != null ? stack1["0"] : stack1)) != null ? stack1.title : stack1), depth0))
    + "\n";
},"4":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "					<select id=\"roster_form_enrollment_set_filter\" size=\"1\">\n						<option selected=\"selected\" value=\"\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_enrollment_status_all",{"name":"translate","hash":{},"data":data}))
    + "</option>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentSets : depth0),{"name":"each","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "					</select>\n";
},"5":function(container,depth0,helpers,partials,data) {
    var helper;

  return "							<option value=\""
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"title","hash":{},"data":data}) : helper)))
    + "</option>\n";
},"7":function(container,depth0,helpers,partials,data) {
    var helper;

  return "							<option value=\""
    + container.escapeExpression(((helper = (helper = helpers.thisenrollmentStatusDescription || (depth0 != null ? depth0.thisenrollmentStatusDescription : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"thisenrollmentStatusDescription","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</option>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['enrollment_section_filter'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['enrollment_section_filter'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/enrollment_status.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "<table cellspacing=\"0\" cellpadding=\"0\" class=\"listHier rosterTable\" id=\"roster_form_rosterTable\">\n	<thead>\n		<tr>\n			<th width=\"45%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_name",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewDisplayId : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewEmail : depth0),{"name":"if","hash":{},"fn":container.program(3, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewUserProperty : depth0),{"name":"if","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            <th width=\"12.5%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_status",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n            <th width=\"12.5%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_credits",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n		</tr>\n	</thead>\n	<tbody>\n"
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},((stack1 = (depth0 != null ? depth0.enrollment : depth0)) != null ? stack1.length : stack1),{"name":"unless","hash":{},"fn":container.program(7, data, 0, blockParams, depths),"inverse":container.program(12, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + "	</tbody>\n</table>\n";
},"1":function(container,depth0,helpers,partials,data) {
    return "			<th width=\"10%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userId",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n";
},"3":function(container,depth0,helpers,partials,data) {
    return "				<th width=\"20%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_email",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n";
},"5":function(container,depth0,helpers,partials,data) {
    return "				<th width=\"20%\"><a href=\"#\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userProperties",{"name":"translate","hash":{},"data":data}))
    + "</a></th>\n";
},"7":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "		<tr>\n			<td>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"no_participants",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewDisplayId : depth0),{"name":"if","hash":{},"fn":container.program(8, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewEmail : depth0),{"name":"if","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewUserProperty : depth0),{"name":"if","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "			<td></td>\n			<td></td>\n		</tr>\n";
},"8":function(container,depth0,helpers,partials,data) {
    return "			<td></td>\n";
},"10":function(container,depth0,helpers,partials,data) {
    return "				<td></td>\n";
},"12":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollment : depth0),{"name":"each","hash":{},"fn":container.program(13, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"13":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canViewEnrollment : depth0),{"name":"if","hash":{},"fn":container.program(14, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"14":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper;

  return "			    <tr onMouseOver=\"this.className='rosterTableRowHighlight'\" onMouseOut=\"this.className='rosterTableRow'\">\n					<td>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(15, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].firstNameLastName : depths[2]),{"name":"if","hash":{},"fn":container.program(17, data, 0, blockParams, depths),"inverse":container.program(19, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(21, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "					</td>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewDisplayId : depths[2]),{"name":"if","hash":{},"fn":container.program(23, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewEmail : depths[2]),{"name":"if","hash":{},"fn":container.program(25, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewUserProperty : depths[2]),{"name":"if","hash":{},"fn":container.program(27, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "					<td>"
    + container.escapeExpression(((helper = (helper = helpers.enrollmentStatus || (depth0 != null ? depth0.enrollmentStatus : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"enrollmentStatus","hash":{},"data":data}) : helper)))
    + "</td>\n					<td>"
    + container.escapeExpression(((helper = (helper = helpers.credits || (depth0 != null ? depth0.credits : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"credits","hash":{},"data":data}) : helper)))
    + "</td>\n				</tr>\n";
},"15":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                        <a href=\"javascript:;\" class=\"profile\" data-user-id=\""
    + container.escapeExpression(((helper = (helper = helpers.userId || (depth0 != null ? depth0.userId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"userId","hash":{},"data":data}) : helper)))
    + "\">\n";
},"17":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                        "
    + container.escapeExpression(((helper = (helper = helpers.displayName || (depth0 != null ? depth0.displayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayName","hash":{},"data":data}) : helper)))
    + "\n";
},"19":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                        "
    + container.escapeExpression(((helper = (helper = helpers.sortName || (depth0 != null ? depth0.sortName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"sortName","hash":{},"data":data}) : helper)))
    + "\n";
},"21":function(container,depth0,helpers,partials,data) {
    return "                        </a>\n";
},"23":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <td>"
    + container.escapeExpression(((helper = (helper = helpers.displayId || (depth0 != null ? depth0.displayId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayId","hash":{},"data":data}) : helper)))
    + "</td>\n";
},"25":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <td><a href=\"mailto:"
    + container.escapeExpression(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"email","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"email","hash":{},"data":data}) : helper)))
    + "</a></td>\n";
},"27":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.userProperties : depth0),{"name":"each","hash":{},"fn":container.program(28, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"28":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                            <li>"
    + container.escapeExpression(((helper = (helper = helpers.key || (data && data.key)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"key","hash":{},"data":data}) : helper)))
    + ": "
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</li>\n";
},"useData":true,"useDepths":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['enrollment_status'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['enrollment_status'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/members.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.members : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"1":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "    <div class=\"roster-member roster-table-row\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewPicture : depths[1]),{"name":"if","hash":{},"fn":container.program(2, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].hideNames : depths[1]),{"name":"unless","hash":{},"fn":container.program(7, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewUserDisplayId : depths[1]),{"name":"if","hash":{},"fn":container.program(9, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].enrollmentsMode : depths[1]),{"name":"if","hash":{},"fn":container.program(14, data, 0, blockParams, depths),"inverse":container.program(16, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].showVisits : depths[1]),{"name":"if","hash":{},"fn":container.program(18, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewGroup : depths[1]),{"name":"if","hash":{},"fn":container.program(22, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewEmail : depths[1]),{"name":"if","hash":{},"fn":container.program(28, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewUserProperty : depths[1]),{"name":"if","hash":{},"fn":container.program(30, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n    </div> <!-- /roster-table-row -->\n";
},"2":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper;

  return "        <div class=\"roster-table-cell\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewProfile : depths[1]),{"name":"if","hash":{},"fn":container.program(3, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        <img class=\"roster-picture\" src=\""
    + container.escapeExpression(((helper = (helper = helpers.profileImageUrl || (depth0 != null ? depth0.profileImageUrl : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"profileImageUrl","hash":{},"data":data}) : helper)))
    + "\" title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"profile_picture_alt",{"name":"translate","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.displayName || (depth0 != null ? depth0.displayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayName","hash":{},"data":data}) : helper)))
    + "\" alt=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"profile_picture_alt",{"name":"translate","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.displayName || (depth0 != null ? depth0.displayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayName","hash":{},"data":data}) : helper)))
    + "\" />\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewProfile : depths[1]),{"name":"if","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div> <!-- /roster-table-cell -->\n";
},"3":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <a href=\"javascript:;\" class=\"profile\" data-user-id=\""
    + container.escapeExpression(((helper = (helper = helpers.userId || (depth0 != null ? depth0.userId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"userId","hash":{},"data":data}) : helper)))
    + "\">\n";
},"5":function(container,depth0,helpers,partials,data) {
    return "            </a>\n";
},"7":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "        <div class=\"roster-table-cell roster-name-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_name",{"name":"translate","hash":{},"data":data}))
    + "</div>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(3, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            <span title=\""
    + container.escapeExpression((helpers.getName || (depth0 && depth0.getName) || helpers.helperMissing).call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.firstNameLastName : depth0),{"name":"getName","hash":{},"data":data}))
    + "\">"
    + container.escapeExpression((helpers.getName || (depth0 && depth0.getName) || helpers.helperMissing).call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.firstNameLastName : depth0),{"name":"getName","hash":{},"data":data}))
    + "</span>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n";
},"9":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper;

  return "        <div class=\"roster-table-cell\">\n        <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userId",{"name":"translate","hash":{},"data":data}))
    + "</div>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(10, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        "
    + container.escapeExpression(((helper = (helper = helpers.displayId || (depth0 != null ? depth0.displayId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayId","hash":{},"data":data}) : helper)))
    + "\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewProfile : depths[2]),{"name":"if","hash":{},"fn":container.program(12, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n";
},"10":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <a href=\"javascript:;\" class=\"profile\" data-user-id=\""
    + container.escapeExpression(((helper = (helper = helpers.userId || (depth0 != null ? depth0.userId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"userId","hash":{},"data":data}) : helper)))
    + "\">\n";
},"12":function(container,depth0,helpers,partials,data) {
    return "        </a>\n";
},"14":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_status",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            "
    + container.escapeExpression(((helper = (helper = helpers.enrollmentStatusText || (depth0 != null ? depth0.enrollmentStatusText : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"enrollmentStatusText","hash":{},"data":data}) : helper)))
    + "\n        </div>\n        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_credits",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            "
    + container.escapeExpression(((helper = (helper = helpers.credits || (depth0 != null ? depth0.credits : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"credits","hash":{},"data":data}) : helper)))
    + "\n        </div>\n";
},"16":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_role",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            "
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + "\n        </div>\n";
},"18":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[2] != null ? depths[2].viewSiteVisits : depths[2]),{"name":"if","hash":{},"fn":container.program(19, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"19":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"total_visits",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            "
    + container.escapeExpression(((helper = (helper = helpers.totalSiteVisits || (depth0 != null ? depth0.totalSiteVisits : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"totalSiteVisits","hash":{},"data":data}) : helper)))
    + "\n        </div>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.formattedLastVisitTime : depth0),{"name":"if","hash":{},"fn":container.program(20, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"20":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"last_visit",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            "
    + container.escapeExpression(((helper = (helper = helpers.formattedLastVisitTime || (depth0 != null ? depth0.formattedLastVisitTime : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"formattedLastVisitTime","hash":{},"data":data}) : helper)))
    + "\n        </div>\n";
},"22":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    <div class=\"roster-table-cell\">\n        <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_groups",{"name":"translate","hash":{},"data":data}))
    + "</div>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.hasGroups : depth0),{"name":"if","hash":{},"fn":container.program(23, data, 0),"inverse":container.program(26, data, 0),"data":data})) != null ? stack1 : "")
    + "    </div>\n";
},"23":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "            <div class=\"roster-group-cell\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.groups : depth0),{"name":"each","hash":{},"fn":container.program(24, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </div>\n";
},"24":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <a href=\"javascript:;\" class=\"roster-group-link\" data-groupid=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"title","hash":{},"data":data}) : helper)))
    + "</a>\n";
},"26":function(container,depth0,helpers,partials,data) {
    return "        <span class=\"roster-no-groups-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_group_ungrouped",{"name":"translate","hash":{},"data":data}))
    + "</span>\n";
},"28":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_email",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            <a href=\"mailto:"
    + container.escapeExpression(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"email","hash":{},"data":data}) : helper)))
    + "\" title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"profile_email",{"name":"translate","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"email","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"email","hash":{},"data":data}) : helper)))
    + "</a>\n        </div>\n";
},"30":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "        <div class=\"roster-table-cell\">\n            <div class=\"roster-mobile-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userProperties",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            <ul class=\"roster-user-properties\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.userProperties : depth0),{"name":"each","hash":{},"fn":container.program(31, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </ul>\n        </div>\n";
},"31":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                <li>"
    + container.escapeExpression(((helper = (helper = helpers.key || (data && data.key)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"key","hash":{},"data":data}) : helper)))
    + ": "
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</li>\n";
},"useData":true,"useDepths":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['members'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['members'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/members_header.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "<div id=\"roster-members-header\" class=\"roster-table\">\n    <div class=\"roster-table-header-group\">\n        <div class=\"roster-table-row\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewPicture : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.hideNames : depth0),{"name":"unless","hash":{},"fn":container.program(3, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewUserDisplayId : depth0),{"name":"if","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.enrollmentsMode : depth0),{"name":"if","hash":{},"fn":container.program(7, data, 0, blockParams, depths),"inverse":container.program(9, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.showVisits : depth0),{"name":"if","hash":{},"fn":container.program(11, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " <!-- showVisits -->\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewGroup : depth0),{"name":"if","hash":{},"fn":container.program(14, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewEmail : depth0),{"name":"if","hash":{},"fn":container.program(16, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewUserProperty : depth0),{"name":"if","hash":{},"fn":container.program(18, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n    </div>\n    <div id=\"roster-members\" class=\"roster-table-row-group\"></div>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_picture",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"3":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_name",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"5":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userId",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"7":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_status",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_credits",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"9":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_role",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"11":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].viewSiteVisits : depths[1]),{"name":"if","hash":{},"fn":container.program(12, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            ";
},"12":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"total_visits",{"name":"translate","hash":{},"data":data}))
    + "</div>\n            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"last_visit",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"14":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell roster-group-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_groups",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"16":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_email",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"18":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"roster-table-cell\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"facet_userProperties",{"name":"translate","hash":{},"data":data}))
    + "</div>\n";
},"useData":true,"useDepths":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['members_header'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['members_header'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/navbar.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "    <li id=\"navbar_overview_link\" role=\"menuitem\"><span class=\"firstToolBarItem current\"><a title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_overview_tooltip",{"name":"translate","hash":{},"data":data}))
    + "\" href=\"javascript:;\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_overview",{"name":"translate","hash":{},"data":data}))
    + "</a></span></li>\n    <li id=\"navbar_enrollment_status_link\" role=\"menuitem\"><span><a title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_status_tooltip",{"name":"translate","hash":{},"data":data}))
    + "\" href=\"javascript:;\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_status",{"name":"translate","hash":{},"data":data}))
    + "</a></span></li>\n    <li id=\"navbar_permissions_link\" role=\"menuitem\"><span><a title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_permissions_tooltip",{"name":"translate","hash":{},"data":data}))
    + "\" href=\"javascript:;\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_permissions",{"name":"translate","hash":{},"data":data}))
    + "</a></span></li>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['navbar'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['navbar'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/overview.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.displayTitleMsg : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n<div id=\"roster-filters\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewGroup : depth0),{"name":"if","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    <div class=\"form-group\" id=\"roster-roles-selector-wrapper\">        \n        <label for=\"roster-roles-selector\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roles_label",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div>\n            <select id=\"roster-roles-selector\">\n                <option value=\"all\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_sections_all",{"name":"translate","hash":{},"data":data}))
    + "</option>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(6, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </select>\n        </div>\n    </div>\n    <button id=\"roster-export-button\" title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_export_tooltip",{"name":"translate","hash":{},"data":data}))
    + "\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"navbar_export",{"name":"translate","hash":{},"data":data}))
    + "</button>\n</div>\n\n<div id=\"roster-search-group\">\n    <div class=\"form-group\">\n        <label for=\"roster-search-field\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_text",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div>\n            <input id=\"roster-search-field\" type=\"text\" value=\""
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.searchQuery : depth0),{"name":"if","hash":{},"fn":container.program(8, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" name=\"roster_form_search\" />\n            <input id=\"roster-search-button\" class=\"active\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_button",{"name":"translate","hash":{},"data":data}))
    + "\" name=\"roster_form:search_button\" />\n            <input id=\"roster_form_clear_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_clear_button",{"name":"translate","hash":{},"data":data}))
    + "\" name=\"roster_form:clear_button\" />		\n        </div>	\n     </div>\n</div>\n\n<div id=\"summary\" class=\"row\">\n    <span>\n        <div id=\"roster-members-total\" class=\"rosterRoleTopLine\">"
    + container.escapeExpression(((helper = (helper = helpers.membersTotal || (depth0 != null ? depth0.membersTotal : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"membersTotal","hash":{},"data":data}) : helper)))
    + "</div>\n        <div id=\"roster-role-totals\" class=\"rosterRoleBottomLine\">("
    + container.escapeExpression(((helper = (helper = helpers.roleFragments || (depth0 != null ? depth0.roleFragments : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"roleFragments","hash":{},"data":data}) : helper)))
    + ")</div>\n    </span>	\n</div>\n\n<div id=\"roster_type_selector\" class=\"row\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.viewOfficialPhoto : depth0),{"name":"if","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</div>\n\n<div class=\"row\">\n    <div class=\"form-group col-sm-6\">\n        <button class=\"roster-print-button\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"print_roster",{"name":"translate","hash":{},"data":data}))
    + "</button>\n        <label id=\"roster-pictures-only-label\">\n            <input type=\"checkbox\" id=\"roster-pictures-only-button\" />\n            "
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"pictures_only",{"name":"translate","hash":{},"data":data}))
    + "\n        </label>\n    </div>\n</div>\n\n<div id=\"roster-members-content\"></div>\n<div id=\"roster-loading-image\"><img src=\"/sakai-roster2-tool/images/ajax-loader.gif\" /></div>\n<div class=\"row\">\n    <div class=\"form-group col-sm-6\">\n        <button class=\"roster-print-button\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"print_roster",{"name":"translate","hash":{},"data":data}))
    + "</button>\n    </div>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    return "	<span class=\"instruction rosterTitleMessage\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"title_msg",{"name":"translate","hash":{},"data":data}))
    + "</span>\n";
},"3":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    <div class=\"form-group\" id=\"roster-group-selector-wrapper\">\n        <label for=\"roster-groups-selector-top\" class=\"form-control-label\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"groups",{"name":"translate","hash":{},"data":data}))
    + "</label>\n        <div>\n            <select id=\"roster-groups-selector-top\">\n                <option value=\"all\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_sections_all",{"name":"translate","hash":{},"data":data}))
    + "</option>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.siteGroups : depth0),{"name":"each","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </select>\n        </div>\n    </div>\n";
},"4":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                <option id=\"roster-group-option-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" value=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"title","hash":{},"data":data}) : helper)))
    + "</option>\n";
},"6":function(container,depth0,helpers,partials,data) {
    return "                <option id=\"roster-role-option-"
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "\" value=\""
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "\">"
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</option>\n";
},"8":function(container,depth0,helpers,partials,data) {
    var helper;

  return container.escapeExpression(((helper = (helper = helpers.searchQuery || (depth0 != null ? depth0.searchQuery : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"searchQuery","hash":{},"data":data}) : helper)));
},"10":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    <div class=\"form-inline\">\n        <div class=\"form-group\">\n            <div class=\"radio\">\n                <label>\n                <input style=\"margin-right: 1em;\" type=\"radio\" name=\"roster_picture_type\" value=\"official\" id=\"roster_official_picture_button\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.checkOfficialPicturesButton : depth0),{"name":"if","hash":{},"fn":container.program(11, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "/><span>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_show_official_pictures",{"name":"translate","hash":{},"data":data}))
    + "</span>\n                </label>\n            </div>\n        </div>\n        <div class=\"form-group\">\n            <div class=\"radio\">\n                <label>\n                <input style=\"margin-right: 1em;\" type=\"radio\" name=\"roster_picture_type\" value=\"profile\" id=\"roster_profile_picture_button\" "
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.checkOfficialPicturesButton : depth0),{"name":"unless","hash":{},"fn":container.program(11, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "/><span>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_show_profile_pictures",{"name":"translate","hash":{},"data":data}))
    + "</span>\n                </label>\n            </div>\n        </div>\n    </div>\n";
},"11":function(container,depth0,helpers,partials,data) {
    return "checked";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['overview'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['overview'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/permissions.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<h3>"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"title_permissions",{"name":"translate","hash":{},"data":data}))
    + ": "
    + container.escapeExpression(((helper = (helper = helpers.siteTitle || (depth0 != null ? depth0.siteTitle : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"siteTitle","hash":{},"data":data}) : helper)))
    + "</h3>\n<p class=\"instruction\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"title_msg_permissions",{"name":"translate","hash":{},"data":data}))
    + "</p>\n<table id=\"roster_permissions_table\" class=\"listHier lines tableList\">\n    <thead>\n        <tr class=\"listHier\">\n            <th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_header",{"name":"translate","hash":{},"data":data}))
    + "</th>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n    </thead>\n    <tbody>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_allmembers",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_hidden",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(6, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n	        <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_groups",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(8, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_enrollment",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(10, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_profile",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(12, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_email",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(14, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_user_properties",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(16, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_photo",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(18, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.showVisits : depth0),{"name":"if","hash":{},"fn":container.program(20, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_export",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(23, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n    </tbody>\n</table>\n<div class=\"act\">\n    <input id=\"roster_permissions_save_button\" type=\"button\" class=\"active\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_save_button",{"name":"translate","hash":{},"data":data}))
    + "\"/>\n    <input id=\"roster_cancel_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_cancel_button",{"name":"translate","hash":{},"data":data}))
    + "\"/>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <th style=\"text-align:center;\">"
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + "</th>\n";
},"3":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewallmembers"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewallmembers\"/></td>\n";
},"4":function(container,depth0,helpers,partials,data) {
    return "checked=\"checked\"";
},"6":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewhidden"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewhidden\"/></td>\n";
},"8":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewgroup"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewgroup\"/></td>\n";
},"10":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewenrollmentstatus"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewenrollmentstatus\"/></td>\n";
},"12":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewprofile"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewprofile\"/></td>\n";
},"14":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewemail"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewemail\"/></td>\n";
},"16":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewuserproperties"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewuserproperties\"/></td>\n";
},"18":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewofficialphoto"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewofficialphoto\"/></td>\n";
},"20":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "        <tr>\n            <td align=\"left\">"
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"permissions_visits",{"name":"translate","hash":{},"data":data}))
    + "</td>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.roles : depth0),{"name":"each","hash":{},"fn":container.program(21, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </tr>\n";
},"21":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.viewsitevisits"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.viewsitevisits\"/></td>\n";
},"23":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "            <td align=\"center\"><input type=\"checkbox\" class=\"roster_permission_checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(helpers.roleAllowed || (depth0 && depth0.roleAllowed) || helpers.helperMissing).call(depth0 != null ? depth0 : {},{"name":"roleAllowed","hash":{"permission":"roster.export"},"data":data}),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + " id=\""
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"name","hash":{},"data":data}) : helper)))
    + ":roster.export\"/></td>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['permissions'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['permissions'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/pictures.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.members : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"1":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper;

  return "    <div class=\"roster-member roster-pictureview\">\n        <div class=\"roster-pictureview-picture\">\n            <img src=\""
    + container.escapeExpression(((helper = (helper = helpers.profileImageUrl || (depth0 != null ? depth0.profileImageUrl : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"profileImageUrl","hash":{},"data":data}) : helper)))
    + "\" title=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"profile_picture_alt",{"name":"translate","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.displayName || (depth0 != null ? depth0.displayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayName","hash":{},"data":data}) : helper)))
    + "\" alt=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"profile_picture_alt",{"name":"translate","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.displayName || (depth0 != null ? depth0.displayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"displayName","hash":{},"data":data}) : helper)))
    + "\" />\n        </div>\n\n        <div class=\"roster-name\">\n"
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},(depths[1] != null ? depths[1].hideNames : depths[1]),{"name":"unless","hash":{},"fn":container.program(2, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n    </div>\n";
},"2":function(container,depth0,helpers,partials,data) {
    return "            <span title=\""
    + container.escapeExpression((helpers.getName || (depth0 && depth0.getName) || helpers.helperMissing).call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.firstNameLastName : depth0),{"name":"getName","hash":{},"data":data}))
    + "\">"
    + container.escapeExpression((helpers.getName || (depth0 && depth0.getName) || helpers.helperMissing).call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.firstNameLastName : depth0),{"name":"getName","hash":{},"data":data}))
    + "</span>\n";
},"useData":true,"useDepths":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['pictures'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['pictures'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/print.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<button class=\"roster-print-button\">Print</button>\n<div id=\"roster-members\"></div>\n<button class=\"roster-print-button\">Print</button>\n<div id=\"roster-loading-image\"><img src=\"/sakai-roster2-tool/images/ajax-loader.gif\" /></div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['print'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['print'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/roster2/src/handlebars/search_with_students.handlebars

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "<table id=\"roster_form:search_group\" class=\"searchFilter\">\n	<tbody>\n		<tr>\n			<td>\n				<div id=\"roster_form:search_filter\" class=\"act\">\n					<input id=\"roster_form_search_field\" type=\"text\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_text",{"name":"translate","hash":{},"data":data}))
    + "\" name=\"roster_form_search\" />\n					<input id=\"roster_form_search_button\" class=\"active\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_search_button",{"name":"translate","hash":{},"data":data}))
    + "\" name=\"roster_form:search_button\" />\n					<input id=\"roster_form_clear_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.translate || (depth0 && depth0.translate) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"roster_clear_button",{"name":"translate","hash":{},"data":data}))
    + "\" name=\"roster_form:clear_button\" />\n				</div>\n			</td>\n			<td>\n				<span class=\"instruction\">\n					<div class =\"rosterRoleTopLine\">"
    + container.escapeExpression(((helper = (helper = helpers.students || (depth0 != null ? depth0.students : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"students","hash":{},"data":data}) : helper)))
    + "</div>\n				</span>\n			</td>\n		</tr>\n	</tbody>\n</table>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['search_with_students'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['search_with_students'] = template;



})();
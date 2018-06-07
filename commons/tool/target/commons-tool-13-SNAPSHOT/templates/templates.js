(function () {
// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/comment.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<div class=\"commons-comment-photo\" style=\"background-image:url(/direct/profile/"
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "/image/thumb)\"></div>\n<div class=\"commons-comment-body\">\n    <span id=\"commons-comment-author-name-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\"><a id=\"commons-author-name-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" href=\"javascript:;\" class=\"commons-comment-author-name\">"
    + container.escapeExpression(((helper = (helper = helpers.creatorDisplayName || (depth0 != null ? depth0.creatorDisplayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorDisplayName","hash":{},"data":data}) : helper)))
    + "</a></span>\n    <span id=\"commons-comment-content-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-content\">"
    + ((stack1 = ((helper = (helper = helpers.content || (depth0 != null ? depth0.content : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"content","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</span>\n    <div id=\"commons-comment-options-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-options\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canEdit : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        \n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canDelete : depth0),{"name":"if","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        <span class=\"commons-date\">"
    + container.escapeExpression(((helper = (helper = helpers.formattedCreatedDate || (depth0 != null ? depth0.formattedCreatedDate : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"formattedCreatedDate","hash":{},"data":data}) : helper)))
    + "</span>\n    </div>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <a href=\"javascript:;\" id=\"commons-comment-edit-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-edit-link\" data-comment-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" data-creator-id=\""
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","edit",{"name":"tr","hash":{},"data":data}))
    + "</a>\n";
},"3":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <a href=\"javascript:;\" id=\"commons-comment-delete-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-delete-link\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.postId || (depth0 != null ? depth0.postId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"postId","hash":{},"data":data}) : helper)))
    + "\" data-comment-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","del",{"name":"tr","hash":{},"data":data}))
    + "</a>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['comment'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['comment'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/inplace_comment_editor.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<div class=\"commons-photo commons-comment-photo\" style=\"background-image:url(/direct/profile/"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.currentUserId : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.program(3, data, 0),"data":data})) != null ? stack1 : "")
    + "/image/thumb)\"></div>\n<div class=\"commons-editor-text-wrapper\">\n    <div class=\"commons-editor-text commons-comment-editor-text\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\"><textarea id=\"commons-comment-textarea-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-textarea\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\"></textarea></div>\n    <div id=\"commons-comment-post-buttons-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">\n        <button id=\"commons-inplace-comment-editor-post-button-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","post_comment",{"name":"tr","hash":{},"data":data}))
    + "</button>\n        <button id=\"commons-inplace-comment-editor-cancel-button-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "</button>\n    </div>\n</div>\n";
},"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return container.escapeExpression(((helper = (helper = helpers.currentUserId || (depth0 != null ? depth0.currentUserId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"currentUserId","hash":{},"data":data}) : helper)));
},"3":function(container,depth0,helpers,partials,data) {
    var helper;

  return container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)));
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['inplace_comment_editor'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['inplace_comment_editor'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/inplace_post_editor.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<textarea id=\"commons-inplace-post-editor-"
    + container.escapeExpression(((helper = (helper = helpers.postId || (depth0 != null ? depth0.postId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"postId","hash":{},"data":data}) : helper)))
    + "\" style=\"width: 100%; resize: none\">"
    + ((stack1 = ((helper = (helper = helpers.content || (depth0 != null ? depth0.content : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"content","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</textarea>\n<div>\n    <button id=\"commons-inplace-post-editor-post-button-"
    + container.escapeExpression(((helper = (helper = helpers.postId || (depth0 != null ? depth0.postId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"postId","hash":{},"data":data}) : helper)))
    + "\">Post</button>\n    <button onclick=\"commons.utils.cancelPostEdit('"
    + container.escapeExpression(((helper = (helper = helpers.postId || (depth0 != null ? depth0.postId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"postId","hash":{},"data":data}) : helper)))
    + "');\">Cancel</button>\n</div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['inplace_post_editor'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['inplace_post_editor'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/og_fragment.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "<div class=\"commons-og-fragment\">\n    <div class=\"commons-og-image-wrapper\">\n        <a href=\""
    + container.escapeExpression(((helper = (helper = helpers.url || (depth0 != null ? depth0.url : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"url","hash":{},"data":data}) : helper)))
    + "\" target=\"_blank\"><img class=\"commons-og-image\" src=\""
    + container.escapeExpression(((helper = (helper = helpers.image || (depth0 != null ? depth0.image : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"image","hash":{},"data":data}) : helper)))
    + "\"/></a>\n    </div>\n    <div class=\"commons-og-title\">\n        <a href=\""
    + container.escapeExpression(((helper = (helper = helpers.url || (depth0 != null ? depth0.url : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"url","hash":{},"data":data}) : helper)))
    + "\" target=\"_blank\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"title","hash":{},"data":data}) : helper)))
    + "</a>\n    </div>\n    <div class=\"commons-og-description\">"
    + container.escapeExpression(((helper = (helper = helpers.description || (depth0 != null ? depth0.description : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"description","hash":{},"data":data}) : helper)))
    + "</div>\n    <div class=\"commons-og-sitename\">"
    + container.escapeExpression(((helper = (helper = helpers.siteName || (depth0 != null ? depth0.siteName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"siteName","hash":{},"data":data}) : helper)))
    + "</div>\n</div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['og_fragment'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['og_fragment'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/permissions.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<h2>"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","permissions",{"name":"tr","hash":{},"data":data}))
    + "</h2>\n<table class=\"commons-permissions-table\">\n	<thead>\n		<tr>\n			<th></th>\n			<th width=\"5px\"></th>\n			<th align=\"center\" colspan=\"6\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","post",{"name":"tr","hash":{},"data":data}))
    + "</th>\n		</tr>\n		<tr class=\"listHier\">\n			<th align=\"left\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","role",{"name":"tr","hash":{},"data":data}))
    + ":</th>\n			<th style=\"background: white;border: none;\"></th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","create",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","read_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","update_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","update_own",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","delete_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","delete_own",{"name":"tr","hash":{},"data":data}))
    + "</th>\n		</tr>\n	</thead>\n<tbody>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.perms : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</tbody>\n</table>\n<table class=\"commons-permissions-table\">\n<thead>\n		<tr>\n			<th></th>\n			<th width=\"5px\"></th>\n			<th colspan=\"6\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","comment",{"name":"tr","hash":{},"data":data}))
    + "</th>\n		</tr>\n		<tr class=\"listHier\">\n			<th align=\"left\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","role",{"name":"tr","hash":{},"data":data}))
    + ":</th>\n			<th style=\"background: white;border: none;\"></th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","create",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","read_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","update_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","update_own",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","delete_any",{"name":"tr","hash":{},"data":data}))
    + "</th>\n			<th style=\"text-align:center;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","delete_own",{"name":"tr","hash":{},"data":data}))
    + "</th>\n		</tr>\n	</thead>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.perms : depth0),{"name":"each","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</tbody>\n</table>\n<input id=\"commons_permissions_save_button\" type=\"button\" value=\""
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","save",{"name":"tr","hash":{},"data":data}))
    + "\"/>\n<input type=\"button\" value=\""
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "\" onclick=\"return commons.switchState('home');\"/>\n";
},"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<tr>\n	<td align=\"left\">"
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + "</td>\n	<td></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_create : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.create\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_read_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.read.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_update_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.update.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_update_own : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.update.own\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_delete_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.delete.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_post_delete_own : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.post.delete.own\"/></td>\n</tr>\n";
},"2":function(container,depth0,helpers,partials,data) {
    return "checked=\"checked\"";
},"4":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<tr>\n	<td align=\"left\">"
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + "</td>\n	<td></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_create : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.create\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_read_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.read.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_update_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.update.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_update_own : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.update.own\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_delete_any : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.delete.any\"/></td>\n	<td align=\"center\"><input type=\"checkbox\" class=\"commons-permission-checkbox\" "
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.commons_comment_delete_own : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.role || (depth0 != null ? depth0.role : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"role","hash":{},"data":data}) : helper)))
    + ":commons.comment.delete.own\"/></td>\n</tr>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['permissions'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['permissions'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/permissions_not_set.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div id=\"commons-permissions-not-set-message\" class=\"textblock\">\n    <p>"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","permissions_not_set",{"name":"tr","hash":{},"data":data}))
    + "</p>\n</div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['permissions_not_set'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['permissions_not_set'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/post.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<div id=\"commons-post-outer-container-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-outer-container\">\n\n    <div class=\"commons-post-inner-container\">\n\n        <div class=\"commons-photo\" style=\"background-image:url(/direct/profile/"
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "/image/thumb)\"></div>\n        <div class=\"commons-post-text-container\">\n            <div class=\"commons-post-body\">\n                <div class=\"commons-post-content\"><a id=\"commons-author-name-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-author-name\" href=\"javascript:;\">"
    + container.escapeExpression(((helper = (helper = helpers.creatorDisplayName || (depth0 != null ? depth0.creatorDisplayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorDisplayName","hash":{},"data":data}) : helper)))
    + "</a><span id=\"commons-post-content-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + ((stack1 = ((helper = (helper = helpers.content || (depth0 != null ? depth0.content : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"content","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "<span></div>\n                <div id=\"commons-post-options-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-options\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canComment : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canEdit : depth0),{"name":"if","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.canDelete : depth0),{"name":"if","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.isModified : depth0),{"name":"if","hash":{},"fn":container.program(7, data, 0),"inverse":container.program(9, data, 0),"data":data})) != null ? stack1 : "")
    + "                </div>\n                <div id=\"commons-post-edit-buttons-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-edit-buttons\">\n                    <button id=\"commons-inplace-post-editor-post-button-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","post",{"name":"tr","hash":{},"data":data}))
    + "</button>\n                    <button onclick=\"commons.utils.cancelPostEdit('"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "');\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "</button>\n                </div>\n            </div>\n        </div> <!-- commons-post-text-container -->\n\n    </div> <!-- /commons-post-inner-container -->\n\n    <div id=\"commons-comments-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comments\">\n        <div id=\"commons-comments-container-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">\n        <div class=\"commons-comment-expander\"><a href=\"javascript:;\" id=\"commons-show-comments-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","show_comments",{"name":"tr","hash":{},"data":data}))
    + "</a></div>\n        <div class=\"commons-comment-expander\"><a href=\"javascript:;\" id=\"commons-hide-comments-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" style=\"display: none;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","hide_comments",{"name":"tr","hash":{},"data":data}))
    + "</a></div>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.comments : depth0),{"name":"each","hash":{},"fn":container.program(11, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n        <div id=\"commons-comment-creator-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment-creator\">\n"
    + ((stack1 = container.invokePartial(partials.inplace_comment_editor,depth0,{"name":"inplace_comment_editor","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "        </div>\n    </div> <!-- commons-comments -->\n\n</div> <!-- /commons-post-outer-container -->\n";
},"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <a href=\"javascript:;\" id=\"commons-create-comment-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-create-comment-link\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","comment",{"name":"tr","hash":{},"data":data}))
    + "</a>\n";
},"3":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <a href=\"javascript:;\" id=\"commons-post-edit-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-edit-link\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","edit",{"name":"tr","hash":{},"data":data}))
    + "</a>\n";
},"5":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <a href=\"javascript:;\" id=\"commons-post-delete-link-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post-delete-link\" data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","del",{"name":"tr","hash":{},"data":data}))
    + "</a>\n";
},"7":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <span class=\"commons-date\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","modified_at",{"name":"tr","hash":{},"data":data}))
    + " "
    + container.escapeExpression(((helper = (helper = helpers.formattedModifiedDate || (depth0 != null ? depth0.formattedModifiedDate : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"formattedModifiedDate","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"9":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    <span class=\"commons-date\">"
    + container.escapeExpression(((helper = (helper = helpers.formattedReleaseDate || (depth0 != null ? depth0.formattedReleaseDate : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"formattedReleaseDate","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"11":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = container.invokePartial(partials.wrapped_comment,depth0,{"name":"wrapped_comment","data":data,"indent":"            ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "");
},"usePartial":true,"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['post'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['post'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/posts.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "    <div class=\"commons-post-editor\">\n        <div class=\"commons-photo-text-wrapper\">\n            <div class=\"commons-photo\" style=\"background-image:url(/direct/profile/"
    + container.escapeExpression(((helper = (helper = helpers.currentUserId || (depth0 != null ? depth0.currentUserId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"currentUserId","hash":{},"data":data}) : helper)))
    + "/image/thumb)\"></div>\n            <div class=\"commons-editor-text-wrapper\">\n                <div class=\"commons-editor-text\"><div id=\"commons-post-creator-editor\" contenteditable=\"true\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","post_editor_initial_text",{"name":"tr","hash":{},"data":data}))
    + "</div></div>\n            </div>\n        </div>\n        <div id=\"commons-editor-toolbar\">\n            <button id=\"commons-editor-post-button\" disabled=\"true\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","post",{"name":"tr","hash":{},"data":data}))
    + "</button>\n            <button id=\"commons-editor-cancel-button\" disabled=\"true\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "</button>\n            <button id=\"commons-editor-link-button\" class=\"commons-editor-special-button\" title=\""
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","link_button_tooltip",{"name":"tr","hash":{},"data":data}))
    + "\"><span class=\"fa fa-link\"></span></button>\n            <button id=\"commons-editor-image-button\" class=\"commons-editor-special-button\" title=\""
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","image_button_tooltip",{"name":"tr","hash":{},"data":data}))
    + "\"><span class=\"fa fa-picture-o\"></span></button>\n        </div>\n    </div>\n\n    <div id=\"commons-posts-wrapper\">\n        <br />\n        <div id=\"commons-posts\">\n        </div>\n	</div>\n    <div id=\"commons-loading-image\">\n        <img src=\"/commons-tool/images/ajax-loader.gif\" />\n    </div>\n    <div id=\"commons-link-dialog\">\n        <div class=\"commons-dialog-container\">\n            <div id=\"commons-link-dialog-table\">\n                <div class=\"commons-link-dialog-row\">\n                    <div>"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","display_text",{"name":"tr","hash":{},"data":data}))
    + "</div>\n                    <div><input type=\"text\" id=\"commons-link-dialog-text\" /></div>\n                </div>\n                <div class=\"commons-link-dialog-row\">\n                    <div>"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","link_to",{"name":"tr","hash":{},"data":data}))
    + "</div>\n                    <div><input type=\"text\" id=\"commons-link-dialog-url\" /></div>\n                </div>\n            </div>\n            <div id=\"commons-link-dialog-thumbnail-setting\">\n                <input type=\"checkbox\" id=\"commons-link-dialog-load-thumbnail\"/ >\n                <label for=\"commons-link-dialog-load-thumbnail\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","load_thumbnail",{"name":"tr","hash":{},"data":data}))
    + "</label>\n            </div>\n            <button id=\"commons-link-dialog-insert-button\" disabled=\"true\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","insert",{"name":"tr","hash":{},"data":data}))
    + "</button>\n            <button id=\"commons-link-dialog-cancel-button\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "</button>\n        </div>\n    </div>\n    <div id=\"commons-image-dialog\">\n        <div class=\"commons-dialog-container\">\n            <div id=\"commons-link-dialog-table\">\n                <div class=\"commons-link-dialog-row\">\n                    <div id=\"commons-imagefile-instruction\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","choose_image_file",{"name":"tr","hash":{},"data":data}))
    + "</div><input type=\"file\" id=\"commons-image-dialog-file\" accept=\".png,.jpg,.jpeg,.gif,image/png,image/jpeg,image/jpg,image/gif\" />\n                </div>\n            </div>\n            <button id=\"commons-image-dialog-insert-button\" disabled=\"true\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","insert",{"name":"tr","hash":{},"data":data}))
    + "</button>\n            <button id=\"commons-image-dialog-cancel-button\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","cancel",{"name":"tr","hash":{},"data":data}))
    + "</button>\n        </div>\n    </div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['posts'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['posts'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/posts_placeholders.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.posts : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "    <div id=\"commons-post-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post\" data-creator-id=\""
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "\"></div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['posts_placeholders'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['posts_placeholders'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/single_post.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "<div id=\"commons-single-post-title\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","commons_link_preamble",{"name":"tr","hash":{},"data":data}))
    + "<a id=\"commons-view-commons-link\" href=\"javascript:;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","here",{"name":"tr","hash":{},"data":data}))
    + "</a>"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","commons_link_postamble",{"name":"tr","hash":{},"data":data}))
    + "</div>\n<div id=\"commons-post-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-post\" data-creator-id=\""
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "\">\n</div>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['single_post'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['single_post'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/toolbar.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "    <li id=\"commons-permissions-link\" role=\"menuitem\"><span><a href=\"javascript:;\">"
    + container.escapeExpression((helpers.tr || (depth0 && depth0.tr) || helpers.helperMissing).call(depth0 != null ? depth0 : {},"commons","permissions",{"name":"tr","hash":{},"data":data}))
    + "</a></span></li>\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['toolbar'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['toolbar'] = template;


// Source: /root/workspace/steveswinsburg/sakai/389267107/commons/tool/src/webapp/WEB-INF/templates/wrapped_comment.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<div id=\"commons-comment-"
    + container.escapeExpression(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"id","hash":{},"data":data}) : helper)))
    + "\" class=\"commons-comment "
    + container.escapeExpression(((helper = (helper = helpers.orderClass || (depth0 != null ? depth0.orderClass : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"orderClass","hash":{},"data":data}) : helper)))
    + "\"\n            data-post-id=\""
    + container.escapeExpression(((helper = (helper = helpers.postId || (depth0 != null ? depth0.postId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"postId","hash":{},"data":data}) : helper)))
    + "\" data-creator-id=\""
    + container.escapeExpression(((helper = (helper = helpers.creatorId || (depth0 != null ? depth0.creatorId : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorId","hash":{},"data":data}) : helper)))
    + "\" data-creator-display-name=\""
    + container.escapeExpression(((helper = (helper = helpers.creatorDisplayName || (depth0 != null ? depth0.creatorDisplayName : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"creatorDisplayName","hash":{},"data":data}) : helper)))
    + "\"\n            data-created-date=\""
    + container.escapeExpression(((helper = (helper = helpers.createdDate || (depth0 != null ? depth0.createdDate : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"createdDate","hash":{},"data":data}) : helper)))
    + "\" data-modified-date=\""
    + container.escapeExpression(((helper = (helper = helpers.modifiedDate || (depth0 != null ? depth0.modifiedDate : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"modifiedDate","hash":{},"data":data}) : helper)))
    + "\" "
    + ((stack1 = helpers.unless.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.isRecent : depth0),{"name":"unless","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">\n"
    + ((stack1 = container.invokePartial(partials.comment,depth0,{"name":"comment","data":data,"indent":"    ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "</div> <!-- commons-comment -->\n";
},"1":function(container,depth0,helpers,partials,data) {
    return "style=\"display: none;\"";
},"usePartial":true,"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['wrapped_comment'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['wrapped_comment'] = template;



})();
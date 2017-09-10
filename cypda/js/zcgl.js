var win = {
		menus : [
		{
			"icon" : "images/car_48.png",
			"title" : "资产管理",
			href : "page/window/carManager.html",
			target : "#windowContex"
		}],
		initEvents : function() {
			comm.createMume("winMune", win.menus);
		}
}




var system = {
		menus : [{
			"icon" : "images/user.png",
			"title" : "用户管理",
			href : "page/system/UserManager.html",
			target : "#sysContex"
		},{
			"icon" : "images/system.png",
			"title" : "系统参数管理",
			href : "page/system/systemInfo.html",
			target : "#sysContex"
		},{
			"icon" : "images/group_48.png",
			"title" : "角色权限管理",
			href : "page/system/RoleManager.html",
			target : "#sysContex"
		},{
			"icon" : "images/Organization_48.png",
			"title" : "组织架构管理",
			href : "page/system/department.html",
			target : "#sysContex"
		}],
		initEvents : function() {
			comm.createMume("sysMune", system.menus);
		}
}

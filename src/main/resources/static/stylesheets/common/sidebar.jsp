<%@page language="java" contentType="text/html; charset=UTF-8"%>
<nav class="navbar navbar-default " role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#"><strong>${companyname }</strong></a>
	</div>
	<!-- /.navbar-header -->
	<ul class="nav navbar-top-links navbar-right">
		<li class="active"><a href="${ctx }/flow/handflow.html?mid=130&mpid=128">待处理事项(<span id="taskcount">0</span>)
			<i class="fa fa-tasks fa-fw"></i> 
		</a></li>
			
			
		<li class="active"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">未读消息(<span id="messagecount">0</span>)
				<i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-alerts" id="messagelist">
			</ul> <!-- /.dropdown-alerts --></li>

		<!-- /.dropdown -->
		
		<%
		top.coolook.model.SysUser checkUser = (top.coolook.model.SysUser)request.getSession().getAttribute("user");
			
		%>
		
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"><%=checkUser.getTruename() %> <i
				class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>

			<ul class="dropdown-menu dropdown-user">
				<li><a href="${ctx }/user/editmyinfo.html" target="main"><i
						class="fa fa-user fa-fw"></i>个人资料</a></li>
				<li><a href="${ctx }/user/editpassword.html" target="main"><i
						class="fa fa-pencil fa-fw"></i>修改密码</a></li>
				<li class="divider"></li>
				<li><a href="${ctx }/system/exit.html"><i
						class="fa fa-sign-out fa-fw"></i>退出登陆</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	<!-- /.navbar-static-side -->
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li><a href="${ctx }/user/main.html"><i class="fa fa-dashboard fa-fw"></i> 首页</a></li>
				
				<%
				int mpid=0;
				int mid=0;
				if(request.getSession().getAttribute("mid")!=null){
					mid = Integer.parseInt(request.getSession().getAttribute("mid").toString());
				}
				if(request.getSession().getAttribute("mpid")!=null){
					mpid = Integer.parseInt(request.getSession().getAttribute("mpid").toString());
				}
				if(request.getParameter("mid")!=null && !"".equals(request.getParameter("mid"))){
					mid = Integer.parseInt(request.getParameter("mid"));
					request.getSession().setAttribute("mid", mid);
				}
				if(request.getParameter("mpid")!=null && !"".equals(request.getParameter("mpid"))){
					mpid = Integer.parseInt(request.getParameter("mpid"));
					request.getSession().setAttribute("mpid", mpid);
				}
				
				top.coolook.model.SysMenu menu=null;
				top.coolook.model.SysMenu lowmenu=null;
				java.util.List<top.coolook.model.SysMenu> menugrouplist = (java.util.List<top.coolook.model.SysMenu>)request.getSession().getAttribute("menugrouplist");
				for(int a =0;a<menugrouplist.size();a++){
					menu = menugrouplist.get(a);
				%>
					<% if(menu.getMenustate()==0 && menu.getMenutype()>0){%>
						<li <%=(menu.getMenuid()==mpid?"class='active'":"") %>>
							<a href="#" ><i class="fa <%=menu.getNavtabid() %> fa-fw"></i>   <%=menu.getMenuname() %><span class="fa arrow"></span></a> 
							<% if(menu.getLowerlist()!=null){%>
									<ul class="nav nav-second-level">
										<% for(int c =0;c<menu.getLowerlist().size();c++){ 
											lowmenu = menu.getLowerlist().get(c);
											if(lowmenu.getMenustate()==0 && lowmenu.getMenutype()>0){
										%>
												<li>   <a href="${ctx }<%=lowmenu.getMenuurl()%>?mid=<%=lowmenu.getMenuid() %>&mpid=<%=lowmenu.getParentid()%>" <%=(lowmenu.getMenuid()==mid?"class='active'":"") %>> <i class="fa <%=lowmenu.getNavtabid() %> fw"></i>  <%=lowmenu.getMenuname() %></a></li>
										<%	}
										} %>
									</ul>
									<!-- /.nav-second-level -->
							<%} %>
						</li>
					<%} %>
				<%} %>
				
				
				
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
</nav>

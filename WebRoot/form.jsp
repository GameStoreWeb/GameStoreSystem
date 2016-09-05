<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>一神带五坑 • 学生管理系统 | 添加学生</title>

		<link rel="stylesheet" type="text/css" href="css/style2.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
	</head>

	<body>
		<form id="userAdd" class="userAdd" action="./AccountService" method="post">
			<input type="hidden" name="action" value="addSeller" />
			<div class="right_content" align="center">
				<h2>商家资料</h2>
				<table id="input-table" style="width: 30%;">
					<tbody>
						<tr>
							<td>
								<span class="">商家名称</span>
							</td>
							<td>
								<input name="sellerName" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">登录密码</span>
							</td>
							<td>
								<input name="sellerPwd" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">商家地址</span>
							</td>
							<td>
								<input name="address" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">商家电话</span>
							</td>
							<td>
								<input name="telephone" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td colspan="2" class="">
								<script type="text/javascript">
								function reset() {
									$(".userAdd")[0].reset();
								}
								function submit() {
									$(".userAdd").submit();
								}
								</script>
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										<a href="javascript:void(0)" class="bt_green" onclick="submit()">添 加 商 家</a>
										<a href="javascript:void(0)" class="bt_green" onclick="javascript:history.back()">返 回</a>
									</div>
									<!--end 按钮 -->
								</div>
								<!-- / 页码 + 按钮 -->
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
		<div class="clear"></div>
	</body>
</html>

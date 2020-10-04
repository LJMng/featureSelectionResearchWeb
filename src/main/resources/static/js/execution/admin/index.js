$(document).ready(function() {
	$('.modal').MultiStep({
		title:'步骤框',
		data:[{
			content:'Hi!!',
			label:'自定义标签'
		},{
			content:'这是一个多步骤模式'
		},{
			content:`你可以选择跳过`,
			skip:true
		},{
			content:`<small>您也可以包含HTML内容！</small><br><br>
			<div class="form-group">
				<label for="exampleInputEmail1">电邮地址</label>
				<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
				<small id="emailHelp" class="form-text text-muted">我们绝不会把你的邮件告诉别人。

</small>
			  </div>
			`,
			skip:true
		},{
			content:`这是结束<BR>屏住呼吸，数到十`,
		}],
		final:'你可以有你自己的最后消息',
		modalSize:'lg'
	});
});
$(document).ready(function() {
	$('.modal').MultiStep({
		title:'步骤框',
		data:[{
			content:'Hi!!',
			label:'自定义标签'
		},{
			content:'这是一个多步骤模式'
		},{
			content:`<form>
                            <!--选择算法 -->
                            <div class="row">
                                <div class="col-md-4 offset-md-2">
                                    <label>选择算法id：</label>
                                    <select v-model="parameterInfo.algorithmId">
                                        <option v-for="algorithm in algorithms">
                                            {{algorithm.algorithmId}}
                                        </option>
                                    </select>
                                </div>
                                <div class="row-md-4">
                                    <button type="button" class="btn btn-link" data-toggle="modal"
                                            v-bind:data-target='"#a"+parameterInfo.algorithmId'>
                                        点击查看算法详情
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 offset-md-2">
                                    <label>参数个数：</label>
                                    <input class="form-control" type="number" v-model.number="paramsNumber"
                                           @click="setDataPopover">
                                </div>
                            </div>
                            <div v-for="n in paramsNumber">
                                <div class="row">
                                    <div class="col-md-4 offset-md-2">
                                        <h2>第{{n}}个参数</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 offset-md-2">
                                        <label for="parameterName" class="col-form-label">参数名：</label>
                                        <input data-toggle="popover" title="参数名称"
                                               data-content="用户输入算法参数时，前端显示给用户进行参数输入的名称,例如在XX算法中,初始化过程中需要执行XX方法迭代运行100次，这里的参数名称则填写迭代次数。"
                                               id="parameterName" class="form-control" type="text"
                                               v-model="parameterInfo.parameterNames[n-1]">
                                    </div>
                                    <div class="col-md-4 ">
                                        <label for="parameterNameMapper" class="col-form-label">映射到算法层的参数名：</label>
                                        <input data-toggle="popover" title="算法层参数名映射"
                                               data-content="用户输入参数后，将参数名称实际传送至算法端的参数，例如在XX算法中，算法参数名称为初始化次数，在此处填写init_number,则实际传送至算法端进行运算的参数名称为init_number。"
                                               id="parameterNameMapper" class="form-control" type="text"
                                               v-model="parameterInfo.parameterNamesMapper[n-1]">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 offset-md-2">
                                        <label for="parameterType" class="col-form-label">参数类型：</label>
                                        <select data-toggle="popover" title="算法层参数名映射"
                                                data-content="参数类型有四种可以进行选择，text表示该参数在前端供用户输入时，为文本框的形式；radio表示该参数在前端供用户输入时为按钮单选形式；checkbox表示该参数在前端给用户输入时，为按钮多选形式；selection表示该参数在前端供用户输入时，为复合参数形式。参数类型的设置可以根据算法具体参数需求进行设置。"
                                                id="parameterType" class="form-control"
                                                v-model="parameterInfo.parameterTypes[n-1]">
                                            <option>text</option>
                                            <option>radio</option>
                                            <option>checkbox</option>
                                            <option>selection</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 offset-md-2">
                                        <label for="parameterDescription" class="col-form-label">参数描述：</label>
                                        <input data-toggle="popover" title="参数描述"
                                               data-content="对该参数进行描述，用户提交参数时可以查看参数描述。" id="parameterDescription"
                                               class="form-control" type="text"
                                               v-model="parameterInfo.parameterDescriptions[n-1]">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 offset-md-2">
                                        <label for="parameterDefaultValue">参数默认值</label>
                                        <input data-toggle="popover" title="参数默认值"
                                               data-content="参数默认值内容，用户不自行选择时，向算法后台提交参数默认值。" id="parameterDefaultValue"
                                               class="form-control" type="text"
                                               v-model="parameterInfo.parameterDefaultValues[n-1]">
                                    </div>
                                </div>
                                <!--判断第一个参数类型是否为input -->
                                <div class="row" v-if="parameterInfo.parameterTypes[n-1] !== 'text'">
                                    <div class="col-md-2 offset-md-2">
                                        <label>第一个值的个数：</label>
                                        <input class="form-control" type="number"
                                               v-model.number="paramValuesNumber[n-1]" @click="setDataPopover">
                                    </div>
                                </div>
                                <hr>
                                <!--                     循环设置第一个参数的值 -->
                                <div v-for="m in paramValuesNumber[n-1]">
                                    <div class="row">
                                        <div class="col-md-4 offset-md-2">
                                            <label for='"firstParamValue"+m' class="col-form-label">Web层取值{{m}}</label>
                                            <input data-toggle="popover" title="客户端取值"
                                                   data-content="参数具体值，该值为用户提交参数时，显示给用户进行选择的参数值。"
                                                   id='"firstParamValue"+m' class="form-control" type="text"
                                                   v-model="firstParameterValues[n-1][m-1]"
                                                   @blur="confirmFirstValue(n,m)">
                                        </div>
                                        <div class="col-md-4">
                                            <label for='"firstAlgorithmParameter"+m'
                                                   class="col-form-label">算法层取值{{m}}</label>
                                            <input data-toggle="popover" title="算法层取值"
                                                   data-content="参数具体值，该值为用户提交参数时，实际提交至算法端进行运算的参数值。例如在XX算法中，初始化步骤中提交的参数值为100，实际传送至算法端进行运算的值为此出填写的init_100。"
                                                   data-placement="right" id='"firstAlgorithmParameter"+m'
                                                   class="form-control" type="text"
                                                   v-model="firstAlgorithmParameterValues[n-1][m-1]"
                                                   @blur="confirmFirstAlgorithmValue(n,m)">
                                        </div>
                                    </div>
                                    <div v-if="parameterInfo.parameterTypes[n-1] === 'selection'">
                                        <div class="row">
                                            <div class="col-md-2 offset-md-2">
                                                <label for='"secondParameterType"+m'>第二个值参数类型：</label>
                                                <select data-toggle="popover" title="参数值类型"
                                                        data-content="复合参数第二个值的设定需要先确定参数值类型，有seleciton,text,null三种形式，text类型表示第二个值为文本内容，null类型表示无需设置第二个参数值，可以供用户进行输入在第二个值类型取值为selciton后，需要对第二个值进行设置，selection表示为下拉单选框。"
                                                        id='"secondParameterType"+m' class="custom-select"
                                                        v-model="secondParameterTypes[n-1][m-1]" name="paraType"
                                                        @blur="confirmSecondParameterType(n,m)" @click="setDataPopover"
                                                        required>
                                                    <option selected>text</option>
                                                    <option>selection</option>
                                                    <option>null</option>
                                                </select>
                                            </div>
                                            <!--根据类型输入值，文本类型的不用，radio,selection,checkbox的需要输入可能的值 -->

                                            <hr>
                                        </div>
                                        <div v-if="secondParameterTypes[n-1][m-1] === 'selection'">
                                            <div class="row">
                                                <div class="col-md-4 offset-md-2">
                                                    <label for='"secondParameterValue"+m'>Web层第二个参数取值</label>
                                                    <input data-toggle="popover" title="web层第二个参数值"
                                                           data-content="复合参数第二个值Web层取值，该参数值表示在下拉框中，提供给用户进行选择的参数值，如果第二个参数值有多个可选择的值，各个值之间用英文”,“进行分隔。"
                                                           id='"secondParameterValue"+m' type="text" name="value"
                                                           class="form-control"
                                                           v-model="secondParameterValues[n-1][m-1]"
                                                           @blur="confirmSecondParameterValue(n,m)">
                                                </div>
                                                <div class="col-md-4">
                                                    <label for='"secondAlgorithmParameterValue"+m'>算法层第二个参数取值</label>
                                                    <input data-toggle="popover" title="算法层取值"
                                                           data-content="复合参数第二个值算法层的取值，该参数值表示实际传送至算法端进行运算的参数值，如果第二个参数值有多个可选择的值，各个值之间用英文”,“进行分隔。"
                                                           data-placement="right" id='"secondAlgorithmParameterValue"+m'
                                                           type="text" name="value" class="form-control"
                                                           v-model="secondAlgorithmParameterValues[n-1][m-1]"
                                                           @blur="confirmSecondAlgorithmParameterValue(n,m)">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                                <hr>
                            </div>
                            <div class="row">
                                <div class="col-md-2 offset-md-4">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                    <button type="button" class="btn btn-primary submitBtn" @click="createParameter()">
                                        确定
                                    </button>
                                </div>
                            </div>
                        </form>`,
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
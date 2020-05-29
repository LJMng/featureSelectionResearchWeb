$(function(){
	if ($('#pagination').length>0){
	    $('#pagination').whjPaging({
	        css: 'css-3',
	        totalSize: 2,
	        totalPage: 2,
	        callBack: function (currPage, pageSize) {
	        	alert("方法未实现！");
	        } //*/
	    });
	}
});
			
function setJumpFunction(pagination_id, func){
	$('#'+pagination_id).whjPaging({
		css: 'css-3',
		totalSize: 2,
		totalPage: 2,
		callBack: function (currPage, pageSize) {
			func(currPage, pageSize);
		} 
	});
}
						
function configPageNavigator(pagination_id, currentPage, totalPage, totalSize){
	$('#'+pagination_id).whjPaging("setPage", {
		currPage: currentPage, 
		totalPage: totalPage, 
		totalSize: totalSize
	});
}
						
function configPageNavigatorCurrentPage(pagination_id, currentPage){
	//alert('configPageNavigatorCurrentPage');
	$('#'+pagination_id).whjPaging("setPage", {
		currPage: currentPage
	});
}
function configPageNavigatorTotalPage(pagination_id, currentPage){
	alert('configPageNavigatorTotalPage');
	$('#'+pagination_id).whjPaging("setPage", {
		totalPage: totalPage
	});
}	
function configPageNavigatorTotalSize(pagination_id, totalSize){
	alert('configPageNavigatorTotalSize');
	$('#'+pagination_id).whjPaging("setPage", {
		totalSize: totalSize
	});
}	

//totalSize: 总条数, currPage: 当前页码, pageSize: 每页显示条数, totalPage: 总页数
function pageNavigatorDataSize(pagination_id){
	return $('#'+pagination_id).whjPaging("getPage").totalSize;
}
function pageNavigatorCurrentPage(pagination_id){
	return $('#'+pagination_id).whjPaging("getPage").currPage;
}
function pageNavigatorPageShowSize(pagination_id){
	return $('#'+pagination_id).whjPaging("getPage").pageSize;
}
function pageNavigatorTotalPage(pagination_id){
	return $('#'+pagination_id).whjPaging("getPage").totalPage;
}
function toClick(){
	
	$.get("/first/toProduce", {}, function(result){
		console.log(result);
	});
	
}
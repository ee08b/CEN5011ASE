$(function(){
	var moveUp = function(){
		//move up an item
		var link = $(this),
			dl = link.parents("dl"),
			prev = dl.prev("dl");	
		if(link.is(".up") && prev.length > 0)
			dl.insertBefore(prev);
	};
	
	var addItem = function(){
		//add an new item
		var newTopicName = document.getElementById("newTopicName").value;
		//alert(newTopicName);
		
		if (newTopicName != "") {
			var sortable = $(this).parents(".ui-sortable");
			var options = '<span class="options"><a class="up"><%@include file = "up.gif" %><img src="Postage_files/JS/up.gif" border="0"></a></span>';
			var html = '<dl class="sort"><dt>'+newTopicName+options+'</dt></dl>';
			sortable.append(html).sortable("refresh").find("a.up").bind("click", moveUp);
			
			var tmp = document.createElement("form");
			//	var subTopicResult = document.getElementById('subTopicResult').innerHTML;
			var action = "servlets/MgIntServlet?" + 
						 "requestType=addTopic&" +
						 "newTopic=" + newTopicName; 
			tmp.action = action; 
			alert("action: " + action);
			tmp.method = "post"; 
			document.body.appendChild(tmp); 
			tmp.submit();  
			
			document.getElementById("newTopicName").value = null;
		}
				
	};
	
	var emptyTrashCan = function(item){
		//trashcan
		item.remove();
	};
	
	var sortableChange = function(e, ui){
		//drag an item
		if(ui.sender){
			var w = ui.element.width();
			ui.placeholder.width(w);
			ui.helper.css("width",ui.element.children().width());
		//	trashcan.visibility = visible;
		//	trashcan.style.visibility = visible;
		}
	};
	
	var sortableUpdate = function(e, ui){
		//update items (after trashcan is flushed)
		if(ui.element[0].id == "trashcan"){
			emptyTrashCan(ui.item);
		//	document.getElementById('deletedInterest').innerHTML = $(ui.item).text();

			var tmp = document.createElement("form");
			//	var subTopicResult = document.getElementById('subTopicResult').innerHTML;
			var action = "servlets/MgIntServlet?" + 
						 "requestType=deleteInterest&" +
						 "delInt=" + $(ui.item).text(); 
			tmp.action = action; 
		//	alert("action: " + action);
			tmp.method = "post"; 
			document.body.appendChild(tmp); 
			tmp.submit(); 
		}
	};
	
	$(function(){
		//reference all items in the page
		var els = ['#header', '#content', '#sidebar', '#footer', '#trashcan'];
		var $els = $(els.toString());

		//dynamically add "add item", "move up" buttons
		$("h2", $els.slice(0,-1)).append('<span class="options"><a class="add"><img src="./Postage_files/JS/add.gif" border="0"></a></span>');
		$("dt", $els).append('<span class="options"><a class="up"><img src="./Postage_files/JS/up.gif" border="0"></a></span>');
		
		//bind
		$("a.add").bind("click", addItem);
		$("a.up").bind("click", moveUp);
		
		//use jQuery plug-in
		$els.sortable({
			items: '> dl',	//drag object
			handle: 'dt',	//trigger event
			cursor: 'move',	//mouse
			opacity: 0.8,	//tansparent when draging
			appendTo: 'body',
			connectWith: els,
			start: function(e,ui) {
				ui.helper.css("width", ui.item.width());
			},
			change: sortableChange,
			update: sortableUpdate		//for trashcan
		});		
	});
});
createStep({
	getUrl: function() {
		return "http://tagthe.net/api/?url=tagesschau.de";
	},
	run: function() {		
	
		print( "TAGS FROM tagthe.net for tagesschau.de" );
		
		for each( var dim in this.xmlObj..dim ) {
			
			var items = "";
			
			for each( var item in dim..item )
				items += String(item)+" ";
			
			print( dim.@type+":"+items );
		}
		
	}
});
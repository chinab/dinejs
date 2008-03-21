createStep({
	getUrl: function() {
		return "http://www.tagesschau.de/newsticker.rdf";
	},
	run: function() {		
			
		for each( var title in this.xmlObj..item..title ) {
			print( String(title) );
		}
	}
});
createStep({
	getUrl: function( ctx ) {
		return "http://www.tagesschau.de/newsticker.rdf";
	},
	
	run: function( ctx ) {		

		// create E4X object from the XML response
		var xml = new XML( ctx.getResponse() );
		
		// find all articles in the RSS	
		for each( var article in xml..item ) {
		
			print( "Found article: "+article.title+" ("+article.link+")" );
			
			// add the tagging step
			ctx.addStep( "/tagArticle", createMap({ url: article.link, title: article.title }) );
		}
	}
	
});
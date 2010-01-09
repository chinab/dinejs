createStep({
	getUrl: function( ctx ) {
		// give the article's url to tagthe.net 
		return "http://tagthe.net/api/?url="+ctx.getParam("url");
	},
	run: function( ctx ) {		
		
		// create an E4X object from the response
		var xml = new XML( ctx.getResponse() );
		
		// our own XML output
		var output = <article title={ctx.getParam("title")} url={ctx.getParam("url")}/>;
		
		// find all tags from tagthe.net's XML response
		for each ( var tags in xml..dim ) {			
			for each ( var tag in tags.item ) {
			 			
			 	// add the tag to our output		
				output.appendChild(
							<tag type={tags.@type}>{tag.text()}</tag>
						);
						
			}			
		}
		
		print( output.toXMLString() );
	}
});
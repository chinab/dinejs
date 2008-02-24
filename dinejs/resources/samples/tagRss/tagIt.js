createStep({
	getUrl: function() {
		return "http://tagthe.net/api/?url="+this.params.url;
	},
	run: function() {		
		
		var result= <result url={this.params.url} />;
		
		for each( var dim in this.xmlObj..dim ) {
				
			var type = String( dim.@type );
			
			if ( type == "location" || type == "person" || type == "topic" ) {
			
				var tags = <tags type={type}/>;
				
				for each( var item in dim..item )
					tags.appendChild( <tag>{String(item)}</tag> ); 
					
				result.appendChild( tags );	
			}
		}
		
		print( "tagged "+this.params.url+"..." );
		
		this.addToMemory( this.params.url, result.toXMLString() ); 		
	}
});
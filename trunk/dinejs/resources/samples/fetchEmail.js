createStep({
	getUrl: function() {
		return "http://yalpani.de";
	},
	run: function() {		
	
		for each( var link in this.xmlObj..a.@href ) 
			if ( link.match(/^mailto:/) )
				out.println( unescape( String(link).replace( /mailto:/g, "" ) ) );
	}
});
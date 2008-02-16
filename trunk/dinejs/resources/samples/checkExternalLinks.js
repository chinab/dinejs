createStep({
	getUrl: function() {
		return "http://newsride.org";
	},
	run: function() {		
				
		for each( var link in this.xmlObj..a.@href ) 
			if ( link.match(/^http/) )
				addStep("check404", { url: unescape(link) });		

	}
});
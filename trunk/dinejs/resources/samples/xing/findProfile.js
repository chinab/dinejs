createStep({
	getUrl: function() {
		return this.params.url;
	},
	run: function() {		
		
		for each( var profileLink in this.xmlObj..a.(@className="l").@href )
			if ( profileLink.match(/^http:\/\/www.xing.com\/profile\//) )
				addStep( "xing/parseProfile", { url: profileLink } );
				
	}
});
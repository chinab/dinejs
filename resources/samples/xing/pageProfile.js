createStep({
	getUrl: function() {
		return getGoogleUrl();
	},
	run: function() {		

		var pageCount = this.xmlObj..table.(@className="t bt")[3]..td.(@align="right")..b[3];
		
		pageCount = (pageCount - pageCount%10) / 10;
					
		for ( var n = 0 ; n <= pageCount ; n++ )
			addStep("xing/findProfile", { url: getGoogleUrl()+"&start="+(n*10) });
				
	}
});

function getGoogleUrl() {
	return "http://www.google.de/search?hl=de&official&hs=YSE&q=user+profile++site%3Axing.com+profile&btnG=Suche&meta=";
}
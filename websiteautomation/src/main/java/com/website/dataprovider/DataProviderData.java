package com.website.dataprovider;





import org.testng.annotations.DataProvider;

import com.website.constant.FileConstant;
import com.website.util.ProviderData;

public class DataProviderData {

	
	/**
	 * Data provider 1
	 * @return
	 */
		@DataProvider(name ="productdetail" )
		public Object[][] getDataOne() {
			ProviderData provideData = new ProviderData(FileConstant.testdata);
			Object[][] getData = provideData.provideData();
			return getData;
		}
	
		
		/**moreinfotestdata
		 * data provider 2
		 * @return
		 */
		@DataProvider(name = "productdescription")
		public Object[][] getDataSecond() {
			ProviderData provideData = new ProviderData(FileConstant.productdescription);
			Object[][] getData = provideData.provideData();
			return getData;
		}
		
		/**
		 * Data provider 3
		 * @return
		 */
			@DataProvider(name = "productReview")
			public Object[][] getDataThird() {
				ProviderData provideData = new ProviderData(FileConstant.productReview);
				Object[][] getData = provideData.provideData();
				return getData;
			}
//		
//			/**
//			 * Data provider 4
//			 * @return
//			 */
//				@DataProvider(name = "productReview")
//				public Object[][] getDataForth() {
//					ProviderData provideData = new ProviderData(FileConstant.productReview);
//					Object[][] getData = provideData.provideData();
//					return getData;
//				}
//		
//		
		
		
}

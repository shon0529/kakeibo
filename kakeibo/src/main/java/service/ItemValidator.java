package service;

import javax.servlet.http.HttpServletRequest;

import domain.Item;

public class ItemValidator {
	
	private Item validatedItem;
	private boolean isValid;
	
	public ItemValidator(HttpServletRequest request) {
		//入力値の取得
		String contents = request.getParameter("contents");
		String strPrice = request.getParameter("price");
		
		//バリデーション
		int price = 0;
		String contentsError = null;
		String priceError = null;
		
		if(contents.isBlank()) {
			contentsError = "品名が未入力です。";
		}else if (contents.length() > 50) {
			contentsError = "50文字以下で入力してください。";
		}
		
		if(strPrice.isEmpty()) {
			priceError = "数量が未入力です。";
		}else {
			try {
				price = Integer.parseInt(strPrice);
				if(price < 0) {
					priceError = "0以上の数を入力してください。";
				}
			}catch(NumberFormatException e) {
				priceError = "整数を入力してください。";
			}
		}
		
		//バリデーションエラーの場合
		if(contentsError != null || priceError != null) {
			//フォーム入力値再表示用
			request.setAttribute("contents", contents);
			request.setAttribute("price", strPrice);
			
			//エラーメッセージ表示用
			request.setAttribute("contentsError", contentsError);
			request.setAttribute("priceError", priceError);
			return;
		}
		
		//バリデーションエラーがない場合
		validatedItem = new Item();
		validatedItem.setContents(contents);
		validatedItem.setPrice(price);
		
		isValid = true;
	}
	
	public Item getValidatedItem() {
		return validatedItem;
	}
	public boolean isValid() {
		return isValid;
	}
}

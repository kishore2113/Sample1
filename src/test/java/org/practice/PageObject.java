package org.practice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends BaseClass {
	@FindBy(id = "username")
	private WebElement userName;

	public WebElement getTxtUserName() {
		return userName;
	}

	@FindBy(id = "password")
	private WebElement txtPassword;

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	@FindBy(id = "login")
	private WebElement btnLogIn;

	public WebElement getBtnLogIn() {
		return btnLogIn;
	}

	@FindBy(id = "location")
	private WebElement txtLocation;

	public WebElement getTxtLocation() {
		return txtLocation;
	}

	@FindBy(id = "hotels")
	private WebElement ddHotels;

	public WebElement getDdHotels() {
		return ddHotels;
	}

	@FindBy(id = "room_type")
	private WebElement ddRoomType;

	public WebElement getDdRoomType() {
		return ddRoomType;
	}

	@FindBy(id = "room_nos")
	private WebElement ddRooms;

	public WebElement getDdRooms() {
		return ddRooms;
	}

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	@FindBy(id = "adult_room")
	private WebElement ddAdultsPerRoom;

	public WebElement getDdAdultsPerRoom() {
		return ddAdultsPerRoom;
	}

	@FindBy(id = "child_room")
	private WebElement ddChildPerRoom;

	public WebElement getDdChildPerRoom() {
		return ddChildPerRoom;
	}

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnSelect;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	@FindBy(id = "continue")
	private WebElement btnContinue;

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	@FindBy(id = "address")
	private WebElement txtAddress;

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	@FindBy(id = "cc_num")
	private WebElement txtCcNumber;

	public WebElement getTxtCcNumber() {
		return txtCcNumber;
	}

	@FindBy(id = "cc_type")
	private WebElement ddCcType;

	public WebElement getDdCcType() {
		return ddCcType;
	}

	@FindBy(id = "cc_exp_month")
	private WebElement ddExpiryMonth;

	public WebElement getDdExpiryMonth() {
		return ddExpiryMonth;
	}

	@FindBy(id = "cc_exp_year")
	private WebElement ddExpiryYear;

	public WebElement getDdExpiryYear() {
		return ddExpiryYear;
	}

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	@FindBy(id = "order_no")
	private WebElement txtOrderId;

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public PageObject() {
		PageFactory.initElements(driver, this);
	}
	

}

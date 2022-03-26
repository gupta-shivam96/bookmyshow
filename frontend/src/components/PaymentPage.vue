<template>
 <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/movies_Details">About</router-link> |
    <router-link to="/movies">movies</router-link>
  </nav> --><div>

  <router-view/>
  <div class="header-container">
				<h2>
					<!-- Event name -->
					<div>
						<span class="__event-name"><a id="strEvtName" href="#" onclick="fnCanTr();">Gangubai Kathiawadi</a></span>
						<span class="icon-a" id="sen_a" style="display: none;">
							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
								<use xlink:href="/icons/common-icons.svg#icon-a"></use>
							</svg>
						</span>
						<span class="icon-u" id="sen_u" style="display: none;">
							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
								<use xlink:href="/icons/common-icons.svg#icon-u"></use>
							</svg>
						</span>
						<span class="icon-ua" id="sen_ua" style="display: inline-block;">
							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
								<use xlink:href="/icons/common-icons.svg#icon-ua"></use>
							</svg>
						</span>
					</div>
				<!-- Event details such as venue name and timing -->
					<div>
						<span class="__event-details">
							<span id="strVenName">Amba Cinema: Delhi</span>
							<span>|</span>
							<span id="strDate" style="display: inline-block;">Today, 09 Mar, 12:20 PM</span>
						</span>
					</div>
				</h2>


				<!-- Event componets such as quantity and showtimes -->
				
				<div class="right-evt-component">
					<div class="event-components" id="evcomp" style="display: none;">
						<div id="mob-qty" class="mob-btn" onclick="javascript:BMS.Misc.modal('qty-sel', 1);">No. OF TICKETS | <span id="mobintQty">2</span></div>
						<div id="mob-stm" class="mob-btn" onclick="javascript:BMS.Misc.modal('show-sel', 1);">SHOWTIMES</div>
						<div></div>
						<div class="no-of-tickets no-of-tickets-button" onclick="javascript:BMS.Misc.modal(&quot;qty-sel&quot;, 1);$(&quot;.__seat-action&quot;).hide();">
							<div>
								<span id="intQty">2</span>
								<span id="ticket-text">Tickets</span>
							</div>	
							<div class="__icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 12 12" fill="none">
									<path fill-rule="evenodd" clip-rule="evenodd" d="M9.33553 0.667038C9.86628 0.663445 10.3765 0.872109 10.7526 1.24661L10.7536 1.24769C11.1283 1.62367 11.337 2.13383 11.3335 2.66459C11.3299 3.19456 11.1149 3.70112 10.7362 4.07184L4.36668 10.4414C4.31723 10.4908 4.25541 10.5261 4.18768 10.5434L1.15372 11.3216C1.02013 11.3559 0.878365 11.3171 0.780834 11.2195C0.683303 11.122 0.644488 10.9803 0.678735 10.8467L1.45645 7.81271C1.46062 7.79644 1.46582 7.78051 1.47201 7.765C1.49101 7.71707 1.51989 7.67213 1.55863 7.63332C1.5615 7.63044 1.5644 7.62763 1.56733 7.62486L7.92814 1.26405C8.29899 0.885543 8.80558 0.670626 9.33553 0.667038ZM2.04291 8.66817L1.59853 10.4017L3.3337 9.9567L2.04291 8.66817ZM4.09271 9.61154L2.3871 7.90891L8.02348 2.27256L9.72758 3.97666L4.09271 9.61154ZM10.2013 1.79914C9.97281 1.57193 9.66305 1.44535 9.34082 1.44753C9.06135 1.44942 8.79258 1.54804 8.57913 1.7244L10.2758 3.42104C10.4523 3.20766 10.5511 2.93885 10.553 2.65931C10.5551 2.33715 10.4285 2.02748 10.2013 1.79914Z" fill="white"></path>
								</svg>
							</div>
						</div>
					</div>
					<div id="mobile-date-container" class="__event-date-container">
						<div class="__event-date-wrapper">
							<div class="__calendar-strip __calendar-strip-one"></div>
							<div class="__calendar-strip __calendar-strip-two"></div>
							<div class="__calendar-strip __calendar-strip-three"></div>
							<div class="__calendar-strip __calendar-strip-four"></div>
							<div class="__event-date-holder-one">
								<p id="mobweekday">Today</p>
								<div class="__event-date-holder-two">
									<span id="mobdate">09</span>
								</div>
							</div>
						</div>
					</div>
					<div class="text-adult-movie" id="SetaErrMsg" style="display: none;">
						<span class="error-text" id="SLNew_CenMsg" style="display:none;"></span>
					</div>
				</div>
				
			</div>
  <section id="bksmile" class="bkf-container _add-ons struktur" style="display: block;">
      <div class="fnb-ads-banner" id="web_food_and_beverages" style="display: none;"></div>
  <div id="fnbcont" class="add-ons-container" style="margin-top: 0px;">
        <div id="hdBksmile">
            <div class="bas-container">
                <div class="bas-wrapper">
                    <div class="__cover-image wow" style="visibility: visible;">
                        <img alt="BOOK-A-SMILE" data-src="//in.bmscdn.com/webin/modal/bookasmile-03.jpg?v123"
                            src="//in.bmscdn.com/webin/modal/bookasmile-03.jpg?v123">
                    </div>
                    <div id="BksmileOver" class="__overlay" style="display: block;"></div>
                    <div class="content-container">
                        <div class="__content">
                            <aside class="bas-logo-container none">
                                <svg width="175" height="55">
                                    <image xmlns:xlink="http://www.w3.org/1999/xlink"
                                        xlink:href="//in.bmscdn.com/webin/common/icons/bookasmile.svg" width="175"
                                        height="55"></image>
                                </svg>
                                <span class="__tagline">CREATING SMILES FOR MILES</span>
                                <span class="__power">POWER OF 1</span>
                                <span class="__choice">The choice is yours</span>
                            </aside>
                        </div>
                    </div>
                    <div class="__bas-tnc-block">
                        <h3>Disclaimer</h3>
                        <div class="__left">
                            1. Big Tree Entertainment Pvt Ltd (BEPL) is facilitating the transactions on the platform<a
                                target="_blank"
                                href="https://in.bookmyshow.com/donation">https://in.bookmyshow.com/donation</a>. The
                            proceeds of the same will be used for social initiatives for the underprivileged sections of
                            society.<br><br>
                            2. Apart from this, BEPL is not engaged in any partnership, association or tie-up with the
                            NGOs. <br><br>
                            3. BEPL expressly disclaims any and all liability and assumes no responsibility whatsoever
                            for consequences resulting from any actions or inactions of the NGO.<br><br>
                            4. By proceeding to donate the money, you do so at your own risk and expressly waive any and
                            all claims, rights of action and/or remedies (under law or otherwise) that you may have
                            against BEPL arising out of or in connection with the aforesaid transaction.<br><br>
                        </div>
                        <div class="__right">
                            5. BEPL will not be held responsible for the issuance of 80G certificate.<br><br>
                            6. The amount contributed towards BookASmile is purely a voluntary act of kindness to
                            contribute to the smiles of the less fortunate. In case you have made the contribution to
                            BookASmile by mistake, please reach out to us at<a target="_blank"
                                href="https://support.bookmyshow.com/support/tickets/new">email</a> for a refund of the
                            same. The refund shall be made into the same bank account/wallet/payment channel through
                            which the contribution was made by you.<br><br>
                            7. For any queries, kindly<a target="_blank"
                                href="https://support.bookmyshow.com/support/tickets/new">email us</a>
                        </div>
                    </div>
                    <div class="__bas-info-block">
                        <div class="__block_top">
                            <h5>Who We Are?</h5>
                            <p>BookASmile, the charity initiative of BookMyShow, India’s biggest entertainment
                                destination. Created with a vision to enrich the lives of the less fortunate across
                                India, through the medium of <span class="span-info">"Experiences &amp;
                                    Enjoyment."</span></p><br>
                        </div>
                        <div class="__block_top">
                            <h5>What We Do?</h5>
                            <p>We ensure that the underprivileged sections of society, young and old can be privy to
                                opportunities, by incorporating into their lives, activities and experiences from across
                                genres like <span class="span-info">Sport, Cinema, Art, Theatre &amp; Music.</span></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bkasmile-addon" style="display: none;">
                <p class="__donate">
                    <input id="FLDonation" type="checkbox" class="__green-checkbox" name="rsCheck" value="Rs">
                    <label for="FLDonation">
                        <span class="__tick">
                            <svg version="1.1" xmlns="http://www.w3.org/2000/svg"
                                xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100"
                                enable-background="new 0 0 100 100" xml:space="preserve">
                                <use xlink:href="/icons/payments-icons.svg#icon-tick"></use>
                            </svg>
                        </span>
                        <span><strong class="__bas-bold">ADD <span id="spnSmile">Rs. 2</span></strong> to your
                            transaction as a donation.</span>
                        <span class="__uncheck">(<u>Uncheck if you do not wish to donate</u>)</span>
                        <span id="basInfo" class="info"><svg version="1.1" xmlns="http://www.w3.org/2000/svg"
                                xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100"
                                enable-background="new 0 0 100 100" xml:space="preserve">
                                <use xlink:href="/icons/common-icons.svg#icon-info"></use>
                            </svg></span>
                    </label>
                    <span class="basTNC" id="basTNC">
                        <span class="__arrow" id="bas-tnc-arrow-down"></span>
                        T&amp;C*
                    </span>
                </p>
                <div class="__bas-tnc-block-touch">
                    <h3>Disclaimer</h3>
                    <div class="__block">
                        1. Big Tree Entertainment Pvt Ltd (BEPL) is facilitating the transactions on the platform<a
                            target="_blank"
                            href="https://in.bookmyshow.com/donation">https://in.bookmyshow.com/donation</a>. The
                        proceeds of the same will be used for social initiatives for the underprivileged sections of
                        society.<br><br>
                        2. Apart from this, BEPL is not engaged in any partnership, association or tie-up with the NGOs.
                        <br><br>
                        3. BEPL expressly disclaims any and all liability and assumes no responsibility whatsoever for
                        consequences resulting from any actions or inactions of the NGO.<br><br>
                        4. By proceeding to donate the money, you do so at your own risk and expressly waive any and all
                        claims, rights of action and/or remedies (under law or otherwise) that you may have against BEPL
                        arising out of or in connection with the aforesaid transaction.<br><br>
                        5. BEPL will not be held responsible for the issuance of 80G certificate.<br><br>
                        6. The amount contributed towards BookASmile is purely a voluntary act of kindness to contribute
                        to the smiles of the less fortunate. In case you have made the contribution to BookASmile by
                        mistake, please reach out to us at<a target="_blank"
                            href="https://support.bookmyshow.com/support/tickets/new">email</a> for a refund of the
                        same. The refund shall be made into the same bank account/wallet/payment channel through which
                        the contribution was made by you.<br><br>
                        7. For any queries, kindly<a target="_blank"
                            href="https://support.bookmyshow.com/support/tickets/new">email us</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="fnb-container" id="shfnb" style="display:none;">
            <div class="fnb-section">
                <div class="block">
                    <h2 class="__heading-text-plus-red" id="grab-a-bite">Grab a <span>bite!</span><br>
                        <!--<span class="sub-head" id="text-none">Now get your favorite snack at a discounted price !!!</span>-->
                    </h2>
                    <div class="exclusive-fullmenu-container" style="display:none;">
                        <div class="tabs-menu" onclick="exclFullmenuCategorization(this, 'EXCLUSIVE');"> EXCLUSIVE MENU
                        </div>
                        <div class="tabs-menu" onclick="exclFullmenuCategorization(this, 'FULL');"> CINEMA MENU </div>
                    </div>
                    <span class="sub-head fc-text" id="text-none">Prebook Your Meal and<span> Save More!</span></span>
                    <div class="fnb-error" style="display: none;"></div>
                    <div class="fnb-filters" id="bkng-flow-filters" style="display:none;"></div>

                    <div class="fnb-container" id="fnbcall"></div>
                </div>
            </div>
        </div>
 <div id="ordPayLat" class="or-sum-pay-later" style="display: none;">
            <div class="top-block">
                <div class="__head-title">Reserve A Seat</div>
                <div class="__svg-sec">
                    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                        x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
                        <use xlink:href="/icons/buytickets-icons.svg#icon-unpaid"></use>
                    </svg>
                </div>
                <div class="__note">
                    <p class="_bold">Please confirm your booking by Paying Online by <strong id="cutMin"></strong>.</p>
                    <p class="__alt-text">(If you do not confirm your booking will be cancelled automatically)</p>
                </div>
            </div>
            <div class="bottom-block">
                <div class="cancellation-policy">
                    <h3 class="__head-title">Cancellation Policy</h3>
                    <ul>
                        <li>You can cancel your booking upto <strong class="cutTime"></strong>.</li>
                        <li>You will not be charged for any cancellations.</li>
                        <li>In case you can’t confirm your booking by paying online till <strong
                                class="cuthour"></strong> before the show, your booking will be cancelled automatically.
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="bkf-notes">
            <span id="fnb-flow-notes" class="__transaction-info" style="display:none;">Note:
                <ol>
                    <li>Images are for representation purposes only</li>
                    <li>Prices inclusive of taxes</li>
                </ol>
            </span>
            <span id="CPGR-3D" class="__transaction-info" style="display: none;">3D Movies : Customer need to pay
                additional charges at the box office for 3D glasses.</span>
            <span id="FNSD-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 30 and DEPOSIT (refundable) of Rs. 20 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNAM-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 30 and DEPOSIT (refundable) of Rs. 20 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNAS-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 100 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNBH-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 30 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNBP-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs.30 and DEPOSIT (refundable) of Rs. 100 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNCH-3D" class="__transaction-info" style="display: none;">For 3D Glasses an Usage DEPOSIT
                (refundable) of Rs. 20 will have to be paid per ticket at the Cinema.</span>
            <span id="FNGW-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 30 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNKT-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 30 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNLK-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 30 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNPN-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs. 20 and DEPOSIT (refundable) of Rs. 30 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNAN-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE DEPOSIT
                (refundable) of Rs. 50 will have to be paid per ticket at the Cinema.</span>
            <span id="FNCM-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE DEPOSIT
                (refundable) of Rs. 100 will have to be paid per ticket at the Cinema.</span>
            <span id="FNCO-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs.30 and DEPOSIT (refundable) of Rs.50 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNBG-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs.30 and DEPOSIT (refundable) of Rs. 50 will have to be paid per ticket at the
                Cinema.</span>
            <span id="FNJJ-3D" class="__transaction-info" style="display: none;">For 3D Glasses an USAGE CHARGE
                (non-refundable) of Rs.30 and DEPOSIT (refundable) of Rs. 20 will have to be paid per ticket at the
                Cinema.</span>
            <div id="DTLP" class="__transaction-info" style="display: none;">
                <ol>
                    <li><strong>1.</strong> Children above 2 years will require full ticket. They will not be allowed
                        inside without tickets, and NO refund for tickets either.</li>
                    <li><strong>2.</strong> Water, Eatables, Cigarette, Paan, Tobacco, Lighter, Matchbox, Drinks,
                        Alcohol, etc. shall <strong><i><u>STRICTLY NOT</u></i></strong> be permitted inside the
                        premises.</li>
                    <li><strong>3.</strong> Patrons under influence of alcohol shall <strong><i><u>STRICTLY
                                    NOT</u></i></strong> be permitted inside the premises.</li>
                </ol>
            </div>
            <span id="dChildNote3Yrs" class="__transaction-info" style="display:none;">
                <!-- Children 3 years and above will require a separate ticket. -->
                Kids above the age of 3 years will be charged separately.
            </span>
            <span id="dFNote" class="__transaction-info" style="display:none; text-align:justify;">
                <strong>Please Note: For 3D glasses: </strong>
                <br>
                Bangalore: Rs.30 (non-refundable usage charge) collected online as 'additional charges' &amp; Rs.50
                refundable deposit payable at the cinema<br>
                Bhopal: Rs.20 (non-refundable usage charge) collected online as 'additional charges' &amp; Rs.100
                refundable deposit payable at the cinema<br>
                Other centers: Rs.20 OR 30 (non-refundable usage charge) &amp; Rs.50 OR 100 (refundable deposit) payable
                at the cinema.<br>
            </span>
            <span class="__transaction-info" id="fdNote" style="display:none;">
                Bring along your confimation printout to collect the food combo.
            </span>
            <span class="__transaction-info" id="dABICNote" style="display: none;">
                Ticket Categories with Massage/Recliner feature and/or 3D movies may incur an extra charge. Please check
                the exact amount on the payment page before proceeding
            </span>
            <span class="__transaction-info" id="dPrintSMSCompulsoryNote" style="display: none;">
                Customers have to carry the printout and SMS of the booking confirmation in order to collect the tickets
                at the Booking Counter without which the cinema will not issue tickets.
            </span>
            <span class="__transaction-info" id="dPrintOutComp" style="display: none;">
                Printout is Mandatory in order to collect the tickets at the Booking Counter.
            </span>
            <span class="__transaction-info" id="dPrsdNote" style="display: none;">An amount of ₹ 20/- per head shall be
                charged towards the hiring of 3D glasses for 3D movies and the same has to be paid at box office while
                you collect your tickets.</span>
            <span id="spNote" class="__transaction-info">
                <!--An Internet handling fee (per ticket) will be levied. Check the same before completing the transaction.-->
            </span>
            <span id="dFunChandigarhFreePepsi" class="__transaction-info" style="display: none;">
                <!--Free 300ml Pepsi with every ticket purchased. To be collected from the Box Office. Offer valid till stocks last. T&amp;C apply.-->
            </span>
            <span class="__transaction-info" style="color:red;display: none;" id="dPrasadsLargeNotImax">
                Please note that the movies being played on PRASADS LARGE SCREEN are not an IMAX presentation.
            </span>
            <span id="spAjantaTheaterNotes" class="__transaction-info" style="display:none;">
                Print out compulsory while exchanging your tickets.<br>
                Booked tickets will not have allocated seats.<br>
                Seats are alloted on the basis of first come first serve.<br>
                Collect the tickets 30 mins prior to the show.<br>
            </span>
            <div class="__transaction-info" id="dPrithviNotes" style="display: none;">
                <strong>Important Notes: </strong>
                <ol style="margin: 5px 0 0 20px; list-style-type: decimal;">
                    <li>The No Late Admittance rule will be strictly enforced. Kindly arrive early.</li>
                    <li>The Right of Admission is reserved.</li>
                    <li>After purchase, no tickets will be refunded or exchanged.</li>
                    <li>Children below the age of 6 years will not be allowed to enter.</li>
                    <li>In case of a children's show, children below the age of 3 years will not be allowed to enter.
                    </li>
                    <li>Vehicles cannot be parked inside Janki Kutir.</li>
                    <li>The Pay &amp; Park, located opposite Mahesh Lunch Home, can be used for parking.</li>
                </ol>
            </div>
            <div class="__transaction-info" id="inoxnotes" style="display: none;">
                Inox T&amp;C:
                <ul style="margin: 5px 0 0 8px; list-style-type: decimal;">
                    <li>Children above the age of 3 will need a separate ticket ,children will not be allowed in Adult
                        movie .</li>
                    <li>Please carry a valid age proof for A rated movies -18 years and over only would be given entry .
                    </li>
                    <li>Tickets are not refundable or transferable .</li>
                    <li>Outside food and beverages are not allowed ,Right of admission is reserved.</li>
                </ul>
            </div>
            <span class="__transaction-info" id="d3DNoteOS" style="display: none;">For 3D Glasses a
                refundable/non-refundable amount may have to be paid per ticket at the cinema. The exact amount will be
                intimated at the cinema.<br></span>
            <span id="unpaNote" class="__transaction-info" style="display:none;">
                1. An internet handling fee will be levied. Please check the same before completing the transaction.<br>
                2. You can only pay online to confirm your booking upto <strong class="cuthour"></strong> before the
                show.<br>
            </span>
        </div>
    </div>
    <div class="bkf-order-summary-container" style="margin-top: 0px;">
        <div class="order-summary-section">
            <div class="order-summarywrap">
                <div class="order-summary">
                    <span class="__circle-left"></span>
                    <span class="__circle-right"></span>
                    <h2>Booking Summary</h2>
                     <ul class="__details">
                        <li>
                           
                            <div><span id="seatPri" class="__seat-price">Rs. 400.00</span></div>
                            <div class="__breakdown __gstchen" id="HandlingGstChenFeeBreakdown" style="display: none;">
                            </div>
                        </li>
                        <li>
                           
                            <div><span id="bkfee">Rs.63.72</span></div>
                            <div class="__breakdown" id="intHandlingFeeBreakdown">
                                <ul>
                                    <li><span>Base Amount</span><span>Rs.54.00</span></li>
                                    <li><span>Integrated GST (IGST) @ 18%</span><span>Rs.9.72</span></li>
                                </ul>
                            </div>
                        </li>
                        <li id="dOtherCharges" style="display:none;"></li>
                        <li class="_total-section">
                            <div>
                                Sub total
                            </div>
                            <div><span id="subTT" class="__sub-total">Rs.463.72</span></div>
                        </li>
                        <li id="fdd" class="__fnb-section" style="display:none;">
                            
                            <div id="fnbTotal" style="display: none;"></div>
                            <p id="fnbDiscount" style="display:none;" class="__discount-text">You've got Rs.
                                <span></span></p>
                        </li>
                        <li>
                            <ul id="FCDtl" style="display:none;"></ul>
                        </li>
                        <li style="display: none;">
                            <h3 id="cpnfdd" class="__fnb-section" style="display:none;">Coupons <a id="cpnfdAll"
                                    onclick="showCoupons('cpnDeta','cpnfdAll');" href="javascript:;">Hide All</a></h3>
                        </li>
                        <li style="display: none;">
                            <ul id="cpnDeta" style="display:none;"></ul>
                        </li>
                        <!-- <li id ="dOtherCharges" style="display:none;"></li> -->
                        <li id="OffDis" style="display:none;"></li>
                        <li id="basDtl" class="bas-card">
                            <div class="__bas-logo">
                                <div class="__bas-checkbox">
                                    <form class="struktur">
                                        <div id="bascheckboxprocessing" class="_bas-processing"
                                            style="min-width: 0% !important;">
                                            <div class="mini-loader" style="display: none;">
                                                <div class="mini">
                                                </div>
                                            </div>
                                            <div class="bas-container">
                                                <div class="__tick bas-icon">
                                                    <svg version="1.1" xmlns="http://www.w3.org/2000/svg"
                                                        xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                        viewBox="0 0 100 100" enable-background="new 0 0 100 100"
                                                        xml:space="preserve">
                                                        <use xlink:href="/icons/bookasmile-icons.svg#icon-bas"></use>
                                                    </svg>
                                                </div>
                                                <label class="__bas-logo __bas-content">
                                                    <span id="basText" class="__bas-content-text">Contribution to
                                                        BookASmile</span>
                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="__bas-price-container">
                                <div class="__bas-price __bas-new-price" id="basPrice">Rs. 2</div>
                                <div id="basCheckbox" class="__bas-cta" onclick="basUpdate(); isBASUpdated = true;">
                                    Remove</div>
                            </div>
                            <div class="__bas-note bas-new-note">
                                <div class="__bas-desc __bas-content-desc" id="basPriceDesc">(₹1 per ticket has been
                                    added).</div>
                                <div style="display: flex; width: 103%; flex-direction: column;">
                                    <!--<a id="basAdditionalInfo" class="basAdditionalNote bas-new-note basNote">
														VIEW T&C
													</a>-->
                                    <a id="basNote" class="basNote bas-new-note" href="javascript:;">VIEW T&amp;C</a>
                                    <span class="__arrow" id="bas-tnc-arrow-down"></span>
                                    <div class="__bas-additional-content">
                                        <div
                                            style="justify-content: center; width: 100%; display: flex; height: 36px; align-items: center;">
                                            <!--?xml version="1.0" encoding="UTF-8" standalone="no"?-->
                                            <svg width="154px" height="30px" viewBox="0 0 154 40" version="1.1"
                                                xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink">
                                                <!-- Generator: Sketch 39 (31667) - http://www.bohemiancoding.com/sketch -->
                                                <title>Page 1</title>
                                                <desc>Created with Sketch.</desc>
                                                <defs></defs>
                                                <g id="Page-1" stroke="none" stroke-width="1" fill="none"
                                                    fill-rule="evenodd">
                                                    <g id="Review-your-order"
                                                        transform="translate(-105.000000, -1197.000000)">
                                                        <g id="Page-1" transform="translate(105.000000, 1197.000000)">
                                                            <path
                                                                d="M74.9347615,1.3956826 C75.2430329,0.442370964 76.2231977,-0.0480821026 77.1823498,0.269775219 C78.1412456,0.589715144 78.650675,1.57374518 78.3436848,2.52575519 C78.0384884,3.47854618 77.0575549,3.9695199 76.0948153,3.65010063 C75.1346382,3.33068135 74.6277713,2.34769262 74.9347615,1.3956826"
                                                                id="Fill-1" fill="#FF585B"></path>
                                                            <g id="Group-5" transform="translate(54.000000, 1.000000)"
                                                                fill="#FF5A5F">
                                                                <path
                                                                    d="M30.891416,36.4713432 L26.566391,38.569566 L24.4325787,34.6329252 L20.5593264,36.6022869 L18.301488,32.6656461 L14.6824379,34.5670628 L12.1642473,30.499218 L8.42040228,32.2725547 L6.02700651,28.7303069 L2.3492746,30.3029327 L0.218537361,26.3027725 L9.00055732,0.389460826 L18.1646493,3.61359099 C18.1646493,3.61359099 17.2695603,9.67422678 22.1457839,11.254402 C26.8018868,12.7650703 29.6883118,7.69939825 29.6883118,7.69939825 L39.1576003,10.8842193 L30.891416,36.4713432 Z"
                                                                    id="Fill-3"></path>
                                                            </g>
                                                            <path
                                                                d="M80.8346871,3.35106483 C81.1427022,2.39905482 82.1210732,1.90834143 83.0815066,2.2267194 C84.0424524,2.54561802 84.5472693,3.53068936 84.2441229,4.4819184 C83.9368765,5.43470939 82.9561992,5.92438148 81.9947409,5.60548285 C81.0343076,5.28840651 80.5294907,4.30333517 80.8346871,3.35106483"
                                                                id="Fill-6" fill="#FF585B"></path>
                                                            <path
                                                                d="M3.25158447,15.8582168 L3.25158447,26.6781217 L5.23856421,26.6781217 C5.79232526,26.6781217 6.26203559,26.4873031 6.64769519,26.1048851 C7.03258603,25.7232481 7.22554395,25.2572656 7.22554395,24.7074583 L7.22554395,17.8286198 C7.22554395,17.2795935 7.03258603,16.8138713 6.64769519,16.4314533 C6.26203559,16.0495559 5.79232526,15.8582168 5.23856421,15.8582168 L3.25158447,15.8582168 Z M1.62566411,29.9025121 C1.16799764,29.9025121 0.782338039,29.7470979 0.469710326,29.43679 C0.156313856,29.1267424 0,28.7443244 0,28.2903169 L0,6.93712541 C0,6.48363855 0.156313856,6.10148085 0.469710326,5.79065232 C0.782338039,5.48060476 1.16799764,5.32493016 1.62566411,5.32493016 C2.08307433,5.32493016 2.46847767,5.48060476 2.78187414,5.79065232 C3.09475811,6.10148085 3.25158447,6.48363855 3.25158447,6.93712541 L3.25158447,12.6338263 L5.23856421,12.6338263 C5.96119548,12.6338263 6.64154513,12.7715384 7.27986942,13.0456611 C7.91768121,13.3205647 8.47221102,13.6907474 8.94192134,14.1564696 C9.41137542,14.6221917 9.78473491,15.171999 10.0617436,15.8043294 C10.3382397,16.4377011 10.4771284,17.1122043 10.4771284,17.8286198 L10.4771284,24.7074583 C10.4771284,25.4241342 10.3382397,26.0994183 10.0617436,26.732009 C9.78473491,27.3648601 9.41137542,27.914407 8.94192134,28.3801292 C8.47221102,28.8458513 7.91768121,29.2162944 7.27986942,29.490417 C6.64154513,29.7648 5.96119548,29.9025121 5.23856421,29.9025121 L1.62566411,29.9025121 Z"
                                                                id="Fill-8" fill="#333548"></path>
                                                            <path
                                                                d="M18.8223921,15.7149597 C18.2678623,15.7149597 17.7984082,15.9062989 17.4132611,16.2881962 C17.0278578,16.6703539 16.8354123,17.1363364 16.8354123,17.6853627 L16.8354123,24.8508195 C16.8354123,25.4008871 17.0278578,25.8666093 17.4132611,26.247986 C17.7984082,26.630404 18.2678623,26.8214829 18.8223921,26.8214829 C19.3761531,26.8214829 19.8458635,26.630404 20.2315231,26.247986 C20.6164139,25.8666093 20.8093718,25.4008871 20.8093718,24.8508195 L20.8093718,17.6853627 C20.8093718,17.1363364 20.6164139,16.6703539 20.2315231,16.2881962 C19.8458635,15.9062989 19.3761531,15.7149597 18.8223921,15.7149597 M18.8223921,30.0458733 C18.0997608,30.0458733 17.4188987,29.9081612 16.7810869,29.6337782 C16.1425063,29.3596556 15.5887453,28.9889522 15.1192912,28.52323 C14.6495809,28.0575079 14.2757089,27.5082213 13.9992127,26.8753702 C13.7219478,26.2425191 13.5838279,25.5674954 13.5838279,24.8508195 L13.5838279,17.6853627 C13.5838279,16.9689472 13.7219478,16.2944441 13.9992127,15.6610723 C14.2757089,15.0284816 14.6495809,14.4789347 15.1192912,14.0129522 C15.5887453,13.54723 16.1425063,13.1773076 16.7810869,12.902404 C17.4188987,12.6282814 18.0997608,12.4905692 18.8223921,12.4905692 C19.5450234,12.4905692 20.2251168,12.6282814 20.8636973,12.902404 C21.5015091,13.1773076 22.0557826,13.54723 22.525493,14.0129522 C22.9952033,14.4789347 23.3683065,15.0284816 23.6455714,15.6610723 C23.9220676,16.2944441 24.0609563,16.9689472 24.0609563,17.6853627 L24.0609563,24.8508195 C24.0609563,25.5674954 23.9220676,26.2425191 23.6455714,26.8753702 C23.3683065,27.5082213 22.9952033,28.0575079 22.525493,28.52323 C22.0557826,28.9889522 21.5015091,29.3596556 20.8636973,29.6337782 C20.2251168,29.9081612 19.5450234,30.0458733 18.8223921,30.0458733"
                                                                id="Fill-10" fill="#333548"></path>
                                                            <path
                                                                d="M32.4063993,15.7149597 C31.8518695,15.7149597 31.3824154,15.9062989 30.9972684,16.2881962 C30.611865,16.6703539 30.4194196,17.1363364 30.4194196,17.6853627 L30.4194196,24.8508195 C30.4194196,25.4008871 30.611865,25.8666093 30.9972684,26.247986 C31.3824154,26.630404 31.8518695,26.8214829 32.4063993,26.8214829 C32.9601604,26.8214829 33.4298707,26.630404 33.8155303,26.247986 C34.2004212,25.8666093 34.3933791,25.4008871 34.3933791,24.8508195 L34.3933791,17.6853627 C34.3933791,17.1363364 34.2004212,16.6703539 33.8155303,16.2881962 C33.4298707,15.9062989 32.9601604,15.7149597 32.4063993,15.7149597 M32.4063993,30.0458733 C31.6837681,30.0458733 31.0029059,29.9081612 30.3650941,29.6337782 C29.7265136,29.3596556 29.1727525,28.9889522 28.7032985,28.52323 C28.2335881,28.0575079 27.8597161,27.5082213 27.58322,26.8753702 C27.3059551,26.2425191 27.1678351,25.5674954 27.1678351,24.8508195 L27.1678351,17.6853627 C27.1678351,16.9689472 27.3059551,16.2944441 27.58322,15.6610723 C27.8597161,15.0284816 28.2335881,14.4789347 28.7032985,14.0129522 C29.1727525,13.54723 29.7265136,13.1773076 30.3650941,12.902404 C31.0029059,12.6282814 31.6837681,12.4905692 32.4063993,12.4905692 C33.1290306,12.4905692 33.809124,12.6282814 34.4477045,12.902404 C35.0855163,13.1773076 35.6397899,13.54723 36.1095002,14.0129522 C36.5792105,14.4789347 36.9523138,15.0284816 37.2295787,15.6610723 C37.5060748,16.2944441 37.6449635,16.9689472 37.6449635,17.6853627 L37.6449635,24.8508195 C37.6449635,25.5674954 37.5060748,26.2425191 37.2295787,26.8753702 C36.9523138,27.5082213 36.5792105,28.0575079 36.1095002,28.52323 C35.6397899,28.9889522 35.0855163,29.3596556 34.4477045,29.6337782 C33.809124,29.9081612 33.1290306,30.0458733 32.4063993,30.0458733"
                                                                id="Fill-12" fill="#333548"></path>
                                                            <path
                                                                d="M52.1683402,27.645569 C52.3851296,28.0519369 52.4330487,28.4694989 52.3128664,28.8992961 C52.1919154,29.3293537 51.9272069,29.6394013 51.5179721,29.8310008 C51.1325687,30.0460295 50.7230777,30.0996566 50.2894989,29.9921422 C49.8561764,29.8848881 49.5309923,29.6276866 49.3142029,29.2218393 L45.520645,22.3430008 L44.4369544,23.5253987 L44.4369544,28.433574 C44.4369544,28.8875815 44.2798717,29.2699995 43.967244,29.5803074 C43.6538476,29.8903549 43.2684442,30.0460295 42.811034,30.0460295 C42.3531113,30.0460295 41.9677079,29.8903549 41.6550802,29.5803074 C41.3416837,29.2699995 41.1853699,28.8875815 41.1853699,28.433574 L41.1853699,6.9372035 C41.1853699,6.48371665 41.3416837,6.10155895 41.6550802,5.79073041 C41.9677079,5.48042253 42.3531113,5.32500826 42.811034,5.32500826 C43.2684442,5.32500826 43.6538476,5.48042253 43.967244,5.79073041 C44.2798717,6.10155895 44.4369544,6.48371665 44.4369544,6.9372035 L44.4369544,18.6885527 L49.5309923,13.0277767 C49.84362,12.6935189 50.2231296,12.514415 50.6690084,12.4904651 C51.1143748,12.4670358 51.5056719,12.6102148 51.8431561,12.9205227 C52.1801278,13.2071409 52.3607856,13.5715965 52.3851296,14.0131084 C52.4087048,14.4554013 52.2644348,14.8432861 51.9515508,15.1775439 L47.7966773,19.7991009 L52.1683402,27.645569 Z"
                                                                id="Fill-14" fill="#333548"></path>
                                                            <path
                                                                d="M100.53359,26.3556305 C100.966912,25.9974228 101.159614,25.5317006 101.111695,24.9584641 C101.063007,24.3617982 100.822642,23.9195054 100.389064,23.6328871 L96.9932092,21.304016 C96.3907602,20.8739584 95.909006,20.3426343 95.5479466,19.7097832 C95.186631,19.0771925 94.9816292,18.3901937 94.9334538,17.649568 C94.8850221,16.9094628 94.9995669,16.1985141 95.2768318,15.5177632 C95.5533279,14.8370123 95.9692253,14.2460736 96.5234988,13.7444265 C97.0772599,13.2669897 97.7030278,12.9204966 98.4020839,12.7054678 C99.100115,12.490439 99.8230025,12.4427995 100.569721,12.5620285 C101.292353,12.6820385 101.954508,12.9444466 102.556957,13.3502939 C103.158381,13.7566618 103.652436,14.2817382 104.038095,14.9268245 C104.254628,15.3089822 104.308954,15.7148295 104.200815,16.1448871 C104.092421,16.5746844 103.833094,16.8972275 103.423859,17.1122563 C103.038199,17.3270248 102.628964,17.3809121 102.195386,17.2733977 C101.762063,17.1658834 101.436623,16.9211775 101.22009,16.5390198 C100.954869,16.0855329 100.569721,15.8223439 100.06388,15.7507544 C99.5818691,15.6554753 99.1365028,15.786419 98.7270117,16.1448871 C98.3175207,16.4796656 98.1366066,16.9094628 98.1852945,17.4345392 C98.2332137,17.9361862 98.4617907,18.3425542 98.8717942,18.6528621 L102.231517,20.9814728 C102.857541,21.4357407 103.357233,21.984767 103.731105,22.629593 C104.104208,23.274419 104.314591,23.9793802 104.363023,24.7434353 C104.411199,25.508011 104.296654,26.2364015 104.019901,26.9288671 C103.742636,27.6218533 103.315464,28.2310148 102.737615,28.7560911 C102.183085,29.2574778 101.545017,29.6159459 100.822642,29.8309747 C100.100011,30.0460035 99.3532921,30.0933827 98.5827417,29.9741537 C97.8114225,29.854404 97.1195415,29.5857482 96.5053049,29.1681862 C95.8910684,28.750364 95.3911203,28.2068045 95.0059732,27.5380285 C94.7891838,27.1561312 94.7348583,26.7497632 94.843253,26.3197056 C94.951904,25.8899084 95.1984186,25.5676255 95.5840782,25.3523364 C95.993313,25.137568 96.4151042,25.0836806 96.8484267,25.191195 C97.2822617,25.2987094 97.6071895,25.5439359 97.8239789,25.9258333 C98.0886874,26.42722 98.5102223,26.7138383 99.0883273,26.7854278 C99.6180007,26.8814879 100.100011,26.7380486 100.53359,26.3556305"
                                                                id="Fill-16" fill="#333548"></path>
                                                            <path
                                                                d="M110.757644,15.8582168 L110.757644,28.4337562 C110.757644,28.8877637 110.594923,29.2701817 110.269996,29.5802293 C109.944812,29.8902768 109.565558,30.0459514 109.131723,30.0459514 C108.674057,30.0459514 108.288397,29.8902768 107.975769,29.5802293 C107.662373,29.2701817 107.506059,28.8877637 107.506059,28.4337562 L107.506059,14.2460215 C107.506059,13.7925347 107.662373,13.4101166 107.975769,13.0995484 C108.288397,12.7892406 108.674057,12.6338263 109.131723,12.6338263 L119.970424,12.6338263 C120.692799,12.6338263 121.366742,12.7715384 121.993535,13.0456611 C122.619559,13.3205647 123.17332,13.6907474 123.655331,14.1564696 C124.137085,14.6221917 124.516338,15.171999 124.793347,15.8043294 C125.070355,16.4377011 125.208988,17.1122043 125.208988,17.8286198 L125.208988,28.4337562 C125.208988,28.8877637 125.046524,29.2701817 124.721084,29.5802293 C124.396156,29.8902768 124.016646,30.0459514 123.583324,30.0459514 C123.125401,30.0459514 122.739998,29.8902768 122.427114,29.5802293 C122.113717,29.2701817 121.957403,28.8877637 121.957403,28.4337562 L121.957403,17.8286198 C121.957403,17.2795935 121.764445,16.8138713 121.379298,16.4314533 C120.993639,16.0495559 120.524185,15.8582168 119.970424,15.8582168 L117.983188,15.8582168 L117.983188,28.4337562 C117.983188,28.8877637 117.820467,29.2701817 117.49554,29.5802293 C117.170356,29.8902768 116.791102,30.0459514 116.357523,30.0459514 C115.899601,30.0459514 115.514197,29.8902768 115.20157,29.5802293 C114.888173,29.2701817 114.731859,28.8877637 114.731859,28.4337562 L114.731859,15.8582168 L110.757644,15.8582168 Z"
                                                                id="Fill-18" fill="#333548"></path>
                                                            <path
                                                                d="M132.145684,28.4336521 C132.145684,28.8876596 131.988858,29.2700776 131.675974,29.5801252 C131.362577,29.890433 130.976918,30.0458473 130.519764,30.0458473 C130.062097,30.0458473 129.676438,29.890433 129.36381,29.5801252 C129.050414,29.2700776 128.8941,28.8876596 128.8941,28.4336521 L128.8941,14.1027384 C128.8941,13.6492516 129.050414,13.2668335 129.36381,12.9562653 C129.676438,12.6459574 130.062097,12.4905432 130.519764,12.4905432 C130.976918,12.4905432 131.362577,12.6459574 131.675974,12.9562653 C131.988858,13.2668335 132.145684,13.6492516 132.145684,14.1027384 L132.145684,28.4336521 Z M130.519764,10.6989837 C129.96549,10.6989837 129.49578,10.5081652 129.110889,10.1257472 C128.72523,9.74411014 128.532784,9.27812766 128.532784,8.72858073 C128.532784,8.17929412 128.72523,7.71357196 129.110889,7.33115394 C129.49578,6.9495169 129.96549,6.7579174 130.519764,6.7579174 C131.073525,6.7579174 131.543235,6.9495169 131.928895,7.33115394 C132.313786,7.71357196 132.507,8.17929412 132.507,8.72858073 C132.507,9.27812766 132.313786,9.74411014 131.928895,10.1257472 C131.543235,10.5081652 131.073525,10.6989837 130.519764,10.6989837 L130.519764,10.6989837 Z"
                                                                id="Fill-20" fill="#333548"></path>
                                                            <path
                                                                d="M138.287486,29.8308706 C137.58843,29.4250233 137.034669,28.875997 136.625691,28.1830108 C136.215687,27.4905452 136.011198,26.7496591 136.011198,25.9616541 L136.011198,6.93733367 C136.011198,6.48358648 136.173918,6.10142879 136.499102,5.79060025 C136.824286,5.48055269 137.203796,5.3248781 137.637118,5.3248781 C138.094272,5.3248781 138.479932,5.48055269 138.793328,5.79060025 C139.105956,6.10142879 139.263038,6.48358648 139.263038,6.93733367 L139.263038,25.9616541 C139.263038,26.4396115 139.479572,26.7980796 139.91315,27.0365377 C140.298297,27.2755164 140.550962,27.6040471 140.671913,28.021609 C140.792095,28.4396916 140.73162,28.8517867 140.491255,29.257634 C140.274466,29.6395314 139.949282,29.8847579 139.515703,29.992012 C139.082381,30.0995264 138.672377,30.0458994 138.287486,29.8308706"
                                                                id="Fill-22" fill="#333548"></path>
                                                            <g id="Group-26"
                                                                transform="translate(142.000000, 12.000000)"
                                                                fill="#333548">
                                                                <path
                                                                    d="M6.15019871,3.7149597 C5.59592515,3.7149597 5.12621483,3.90629887 4.74106773,4.28819625 C4.35566439,4.67035394 4.16296272,5.13633642 4.16296272,5.6853627 L4.16296272,7.65576571 L8.13717845,7.65576571 L8.13717845,5.6853627 C8.13717845,5.13633642 7.94422053,4.67035394 7.55907344,4.28819625 C7.17367009,3.90629887 6.70395977,3.7149597 6.15019871,3.7149597 M4.16296272,17.652001 C3.15153519,17.2458934 2.35664079,16.612782 1.77853578,15.7529272 C1.20068701,14.8930723 0.911634503,13.9257031 0.911634503,12.8508195 L0.911634503,5.6853627 C0.911634503,4.96894718 1.0500107,4.29444406 1.32701936,3.66107234 C1.60377176,3.0284816 1.9773875,2.47893467 2.44709783,2.01295219 C2.91680815,1.54723004 3.47056921,1.17730763 4.1088935,0.902404005 C4.74670528,0.628281352 5.42756744,0.490569212 6.15019871,0.490569212 C6.87257373,0.490569212 7.55317964,0.628281352 8.19150393,0.902404005 C8.82931571,1.17730763 9.38358927,1.54723004 9.8532996,2.01295219 C10.3230099,2.47893467 10.6961132,3.0284816 10.9731218,3.66107234 C11.2498742,4.29444406 11.3887629,4.96894718 11.3887629,5.6853627 L11.3887629,9.26822128 C11.3887629,9.72222879 11.2319366,10.1043865 10.9190526,10.4146944 C10.6059124,10.7252626 10.2202528,10.8804165 9.76309881,10.8804165 L4.16296272,10.8804165 L4.16296272,12.8508195 C4.16296272,13.2574478 4.27161366,13.6211224 4.48840304,13.9436656 C4.70493617,14.2662088 5.00577628,14.511175 5.39143588,14.6780436 C5.77632672,14.8214829 6.16198631,14.8571474 6.54764591,14.7855579 C6.93253675,14.7139685 7.27002093,14.5348646 7.55907344,14.247986 C7.8719574,13.9139885 8.25121069,13.7465992 8.69708956,13.7465992 C9.14271218,13.7465992 9.53375307,13.9139885 9.87123725,14.247986 C10.1841212,14.5830248 10.3409476,14.9646618 10.3409476,15.3947194 C10.3409476,15.8245166 10.1841212,16.2069347 9.87123725,16.5411925 C9.10043056,17.2818183 8.20329153,17.7530073 7.17982015,17.9563214 C6.15558001,18.1591149 5.15055879,18.057588 4.16296272,17.652001"
                                                                    id="Fill-24"></path>
                                                            </g>
                                                            <path
                                                                d="M71.0275301,22.6909777 C70.4827379,22.6909777 70.0209714,22.8836185 69.6427431,23.2683795 C69.263746,23.6531404 69.0746319,24.1219865 69.0746319,24.675178 C69.0746319,25.2286298 69.263746,25.6974758 69.6427431,26.0819765 C70.0209714,26.4669977 70.4827379,26.6591179 71.0275301,26.6591179 L72.9806845,26.6591179 L72.9806845,22.6909777 L71.0275301,22.6909777 Z M72.9806845,19.4441992 L72.9806845,17.5326298 C72.9806845,17.1481292 72.8740836,16.7930453 72.661138,16.4684195 C72.4479362,16.1435334 72.1640087,15.9092406 71.8088431,15.7650203 C71.4536775,15.6205397 71.0862119,15.5846148 70.7079836,15.6567249 C70.3289865,15.728835 70.00944,15.9092406 69.749344,16.1976811 C69.4415851,16.5105922 69.0684818,16.6665272 68.6305468,16.6665272 C68.1926117,16.6665272 67.8195085,16.5105922 67.5122621,16.1976811 C67.1804155,15.8613407 67.0151328,15.4763194 67.0151328,15.0433982 C67.0151328,14.6104771 67.1804155,14.2259765 67.5122621,13.8888551 C68.2459122,13.1438038 69.110251,12.6687099 70.1042533,12.4640941 C71.098512,12.259999 72.0689391,12.3620466 73.0163036,12.7707574 C73.9864745,13.179989 74.7562562,13.8112781 75.3243674,14.6646248 C75.8922223,15.5184921 76.1766623,16.474407 76.1766623,17.5326298 L76.1766623,28.2825071 C76.1766623,28.7393782 76.0221422,29.1246598 75.7148958,29.43679 C75.4068806,29.7489202 75.0278836,29.9058964 74.5784172,29.9058964 L71.0275301,29.9058964 C70.3174552,29.9058964 69.6483806,29.7671429 69.0213314,29.4909377 C68.394026,29.2147324 67.8497463,28.8416861 67.3879798,28.3725797 C66.9264695,27.9034733 66.5590038,27.3505422 66.2871202,26.7132656 C66.0147241,26.0762493 65.8789104,25.3965397 65.8789104,24.675178 C65.8789104,23.9538163 66.0147241,23.274367 66.2871202,22.63683 C66.5590038,22.0000741 66.9264695,21.4466223 67.3879798,20.9775159 C67.8497463,20.5084095 68.394026,20.1361442 69.0213314,19.8591579 C69.6483806,19.583213 70.3174552,19.4441992 71.0275301,19.4441992 L72.9806845,19.4441992 Z"
                                                                id="Fill-27" fill="#FEFEFE"></path>
                                                        </g>
                                                    </g>
                                                </g>
                                            </svg>
                                        </div>
                                        <br>
                                        <br>
                                        <div style="text-align:center;">
                                            BookMyShow’s charity initiative BookASmile, was created with a vision to
                                            enrich the lives of the less fortunate through activities and experiences
                                            from across genres like Cinema, Sport, Theatre, Music &amp; Arts.
                                            <br>
                                        </div>
                                    </div>
                                    <div class="__bas-tnc-block-touch">
                                        <div
                                            style="justify-content: center; width: 100%; display: flex; height: 50px; align-items: center;">
                                            <!--?xml version="1.0" encoding="UTF-8" standalone="no"?-->
                                            <svg width="154px" height="30px" viewBox="0 0 154 40" version="1.1"
                                                xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink">
                                                <!-- Generator: Sketch 39 (31667) - http://www.bohemiancoding.com/sketch -->
                                                <title>Page 1</title>
                                                <desc>Created with Sketch.</desc>
                                                <defs></defs>
                                                <g id="Page-1" stroke="none" stroke-width="1" fill="none"
                                                    fill-rule="evenodd">
                                                    <g id="Review-your-order"
                                                        transform="translate(-105.000000, -1197.000000)">
                                                        <g id="Page-1" transform="translate(105.000000, 1197.000000)">
                                                            <path
                                                                d="M74.9347615,1.3956826 C75.2430329,0.442370964 76.2231977,-0.0480821026 77.1823498,0.269775219 C78.1412456,0.589715144 78.650675,1.57374518 78.3436848,2.52575519 C78.0384884,3.47854618 77.0575549,3.9695199 76.0948153,3.65010063 C75.1346382,3.33068135 74.6277713,2.34769262 74.9347615,1.3956826"
                                                                id="Fill-1" fill="#FF585B"></path>
                                                            <g id="Group-5" transform="translate(54.000000, 1.000000)"
                                                                fill="#FF5A5F">
                                                                <path
                                                                    d="M30.891416,36.4713432 L26.566391,38.569566 L24.4325787,34.6329252 L20.5593264,36.6022869 L18.301488,32.6656461 L14.6824379,34.5670628 L12.1642473,30.499218 L8.42040228,32.2725547 L6.02700651,28.7303069 L2.3492746,30.3029327 L0.218537361,26.3027725 L9.00055732,0.389460826 L18.1646493,3.61359099 C18.1646493,3.61359099 17.2695603,9.67422678 22.1457839,11.254402 C26.8018868,12.7650703 29.6883118,7.69939825 29.6883118,7.69939825 L39.1576003,10.8842193 L30.891416,36.4713432 Z"
                                                                    id="Fill-3"></path>
                                                            </g>
                                                            <path
                                                                d="M80.8346871,3.35106483 C81.1427022,2.39905482 82.1210732,1.90834143 83.0815066,2.2267194 C84.0424524,2.54561802 84.5472693,3.53068936 84.2441229,4.4819184 C83.9368765,5.43470939 82.9561992,5.92438148 81.9947409,5.60548285 C81.0343076,5.28840651 80.5294907,4.30333517 80.8346871,3.35106483"
                                                                id="Fill-6" fill="#FF585B"></path>
                                                            <path
                                                                d="M3.25158447,15.8582168 L3.25158447,26.6781217 L5.23856421,26.6781217 C5.79232526,26.6781217 6.26203559,26.4873031 6.64769519,26.1048851 C7.03258603,25.7232481 7.22554395,25.2572656 7.22554395,24.7074583 L7.22554395,17.8286198 C7.22554395,17.2795935 7.03258603,16.8138713 6.64769519,16.4314533 C6.26203559,16.0495559 5.79232526,15.8582168 5.23856421,15.8582168 L3.25158447,15.8582168 Z M1.62566411,29.9025121 C1.16799764,29.9025121 0.782338039,29.7470979 0.469710326,29.43679 C0.156313856,29.1267424 0,28.7443244 0,28.2903169 L0,6.93712541 C0,6.48363855 0.156313856,6.10148085 0.469710326,5.79065232 C0.782338039,5.48060476 1.16799764,5.32493016 1.62566411,5.32493016 C2.08307433,5.32493016 2.46847767,5.48060476 2.78187414,5.79065232 C3.09475811,6.10148085 3.25158447,6.48363855 3.25158447,6.93712541 L3.25158447,12.6338263 L5.23856421,12.6338263 C5.96119548,12.6338263 6.64154513,12.7715384 7.27986942,13.0456611 C7.91768121,13.3205647 8.47221102,13.6907474 8.94192134,14.1564696 C9.41137542,14.6221917 9.78473491,15.171999 10.0617436,15.8043294 C10.3382397,16.4377011 10.4771284,17.1122043 10.4771284,17.8286198 L10.4771284,24.7074583 C10.4771284,25.4241342 10.3382397,26.0994183 10.0617436,26.732009 C9.78473491,27.3648601 9.41137542,27.914407 8.94192134,28.3801292 C8.47221102,28.8458513 7.91768121,29.2162944 7.27986942,29.490417 C6.64154513,29.7648 5.96119548,29.9025121 5.23856421,29.9025121 L1.62566411,29.9025121 Z"
                                                                id="Fill-8" fill="#333548"></path>
                                                            <path
                                                                d="M18.8223921,15.7149597 C18.2678623,15.7149597 17.7984082,15.9062989 17.4132611,16.2881962 C17.0278578,16.6703539 16.8354123,17.1363364 16.8354123,17.6853627 L16.8354123,24.8508195 C16.8354123,25.4008871 17.0278578,25.8666093 17.4132611,26.247986 C17.7984082,26.630404 18.2678623,26.8214829 18.8223921,26.8214829 C19.3761531,26.8214829 19.8458635,26.630404 20.2315231,26.247986 C20.6164139,25.8666093 20.8093718,25.4008871 20.8093718,24.8508195 L20.8093718,17.6853627 C20.8093718,17.1363364 20.6164139,16.6703539 20.2315231,16.2881962 C19.8458635,15.9062989 19.3761531,15.7149597 18.8223921,15.7149597 M18.8223921,30.0458733 C18.0997608,30.0458733 17.4188987,29.9081612 16.7810869,29.6337782 C16.1425063,29.3596556 15.5887453,28.9889522 15.1192912,28.52323 C14.6495809,28.0575079 14.2757089,27.5082213 13.9992127,26.8753702 C13.7219478,26.2425191 13.5838279,25.5674954 13.5838279,24.8508195 L13.5838279,17.6853627 C13.5838279,16.9689472 13.7219478,16.2944441 13.9992127,15.6610723 C14.2757089,15.0284816 14.6495809,14.4789347 15.1192912,14.0129522 C15.5887453,13.54723 16.1425063,13.1773076 16.7810869,12.902404 C17.4188987,12.6282814 18.0997608,12.4905692 18.8223921,12.4905692 C19.5450234,12.4905692 20.2251168,12.6282814 20.8636973,12.902404 C21.5015091,13.1773076 22.0557826,13.54723 22.525493,14.0129522 C22.9952033,14.4789347 23.3683065,15.0284816 23.6455714,15.6610723 C23.9220676,16.2944441 24.0609563,16.9689472 24.0609563,17.6853627 L24.0609563,24.8508195 C24.0609563,25.5674954 23.9220676,26.2425191 23.6455714,26.8753702 C23.3683065,27.5082213 22.9952033,28.0575079 22.525493,28.52323 C22.0557826,28.9889522 21.5015091,29.3596556 20.8636973,29.6337782 C20.2251168,29.9081612 19.5450234,30.0458733 18.8223921,30.0458733"
                                                                id="Fill-10" fill="#333548"></path>
                                                            <path
                                                                d="M32.4063993,15.7149597 C31.8518695,15.7149597 31.3824154,15.9062989 30.9972684,16.2881962 C30.611865,16.6703539 30.4194196,17.1363364 30.4194196,17.6853627 L30.4194196,24.8508195 C30.4194196,25.4008871 30.611865,25.8666093 30.9972684,26.247986 C31.3824154,26.630404 31.8518695,26.8214829 32.4063993,26.8214829 C32.9601604,26.8214829 33.4298707,26.630404 33.8155303,26.247986 C34.2004212,25.8666093 34.3933791,25.4008871 34.3933791,24.8508195 L34.3933791,17.6853627 C34.3933791,17.1363364 34.2004212,16.6703539 33.8155303,16.2881962 C33.4298707,15.9062989 32.9601604,15.7149597 32.4063993,15.7149597 M32.4063993,30.0458733 C31.6837681,30.0458733 31.0029059,29.9081612 30.3650941,29.6337782 C29.7265136,29.3596556 29.1727525,28.9889522 28.7032985,28.52323 C28.2335881,28.0575079 27.8597161,27.5082213 27.58322,26.8753702 C27.3059551,26.2425191 27.1678351,25.5674954 27.1678351,24.8508195 L27.1678351,17.6853627 C27.1678351,16.9689472 27.3059551,16.2944441 27.58322,15.6610723 C27.8597161,15.0284816 28.2335881,14.4789347 28.7032985,14.0129522 C29.1727525,13.54723 29.7265136,13.1773076 30.3650941,12.902404 C31.0029059,12.6282814 31.6837681,12.4905692 32.4063993,12.4905692 C33.1290306,12.4905692 33.809124,12.6282814 34.4477045,12.902404 C35.0855163,13.1773076 35.6397899,13.54723 36.1095002,14.0129522 C36.5792105,14.4789347 36.9523138,15.0284816 37.2295787,15.6610723 C37.5060748,16.2944441 37.6449635,16.9689472 37.6449635,17.6853627 L37.6449635,24.8508195 C37.6449635,25.5674954 37.5060748,26.2425191 37.2295787,26.8753702 C36.9523138,27.5082213 36.5792105,28.0575079 36.1095002,28.52323 C35.6397899,28.9889522 35.0855163,29.3596556 34.4477045,29.6337782 C33.809124,29.9081612 33.1290306,30.0458733 32.4063993,30.0458733"
                                                                id="Fill-12" fill="#333548"></path>
                                                            <path
                                                                d="M52.1683402,27.645569 C52.3851296,28.0519369 52.4330487,28.4694989 52.3128664,28.8992961 C52.1919154,29.3293537 51.9272069,29.6394013 51.5179721,29.8310008 C51.1325687,30.0460295 50.7230777,30.0996566 50.2894989,29.9921422 C49.8561764,29.8848881 49.5309923,29.6276866 49.3142029,29.2218393 L45.520645,22.3430008 L44.4369544,23.5253987 L44.4369544,28.433574 C44.4369544,28.8875815 44.2798717,29.2699995 43.967244,29.5803074 C43.6538476,29.8903549 43.2684442,30.0460295 42.811034,30.0460295 C42.3531113,30.0460295 41.9677079,29.8903549 41.6550802,29.5803074 C41.3416837,29.2699995 41.1853699,28.8875815 41.1853699,28.433574 L41.1853699,6.9372035 C41.1853699,6.48371665 41.3416837,6.10155895 41.6550802,5.79073041 C41.9677079,5.48042253 42.3531113,5.32500826 42.811034,5.32500826 C43.2684442,5.32500826 43.6538476,5.48042253 43.967244,5.79073041 C44.2798717,6.10155895 44.4369544,6.48371665 44.4369544,6.9372035 L44.4369544,18.6885527 L49.5309923,13.0277767 C49.84362,12.6935189 50.2231296,12.514415 50.6690084,12.4904651 C51.1143748,12.4670358 51.5056719,12.6102148 51.8431561,12.9205227 C52.1801278,13.2071409 52.3607856,13.5715965 52.3851296,14.0131084 C52.4087048,14.4554013 52.2644348,14.8432861 51.9515508,15.1775439 L47.7966773,19.7991009 L52.1683402,27.645569 Z"
                                                                id="Fill-14" fill="#333548"></path>
                                                            <path
                                                                d="M100.53359,26.3556305 C100.966912,25.9974228 101.159614,25.5317006 101.111695,24.9584641 C101.063007,24.3617982 100.822642,23.9195054 100.389064,23.6328871 L96.9932092,21.304016 C96.3907602,20.8739584 95.909006,20.3426343 95.5479466,19.7097832 C95.186631,19.0771925 94.9816292,18.3901937 94.9334538,17.649568 C94.8850221,16.9094628 94.9995669,16.1985141 95.2768318,15.5177632 C95.5533279,14.8370123 95.9692253,14.2460736 96.5234988,13.7444265 C97.0772599,13.2669897 97.7030278,12.9204966 98.4020839,12.7054678 C99.100115,12.490439 99.8230025,12.4427995 100.569721,12.5620285 C101.292353,12.6820385 101.954508,12.9444466 102.556957,13.3502939 C103.158381,13.7566618 103.652436,14.2817382 104.038095,14.9268245 C104.254628,15.3089822 104.308954,15.7148295 104.200815,16.1448871 C104.092421,16.5746844 103.833094,16.8972275 103.423859,17.1122563 C103.038199,17.3270248 102.628964,17.3809121 102.195386,17.2733977 C101.762063,17.1658834 101.436623,16.9211775 101.22009,16.5390198 C100.954869,16.0855329 100.569721,15.8223439 100.06388,15.7507544 C99.5818691,15.6554753 99.1365028,15.786419 98.7270117,16.1448871 C98.3175207,16.4796656 98.1366066,16.9094628 98.1852945,17.4345392 C98.2332137,17.9361862 98.4617907,18.3425542 98.8717942,18.6528621 L102.231517,20.9814728 C102.857541,21.4357407 103.357233,21.984767 103.731105,22.629593 C104.104208,23.274419 104.314591,23.9793802 104.363023,24.7434353 C104.411199,25.508011 104.296654,26.2364015 104.019901,26.9288671 C103.742636,27.6218533 103.315464,28.2310148 102.737615,28.7560911 C102.183085,29.2574778 101.545017,29.6159459 100.822642,29.8309747 C100.100011,30.0460035 99.3532921,30.0933827 98.5827417,29.9741537 C97.8114225,29.854404 97.1195415,29.5857482 96.5053049,29.1681862 C95.8910684,28.750364 95.3911203,28.2068045 95.0059732,27.5380285 C94.7891838,27.1561312 94.7348583,26.7497632 94.843253,26.3197056 C94.951904,25.8899084 95.1984186,25.5676255 95.5840782,25.3523364 C95.993313,25.137568 96.4151042,25.0836806 96.8484267,25.191195 C97.2822617,25.2987094 97.6071895,25.5439359 97.8239789,25.9258333 C98.0886874,26.42722 98.5102223,26.7138383 99.0883273,26.7854278 C99.6180007,26.8814879 100.100011,26.7380486 100.53359,26.3556305"
                                                                id="Fill-16" fill="#333548"></path>
                                                            <path
                                                                d="M110.757644,15.8582168 L110.757644,28.4337562 C110.757644,28.8877637 110.594923,29.2701817 110.269996,29.5802293 C109.944812,29.8902768 109.565558,30.0459514 109.131723,30.0459514 C108.674057,30.0459514 108.288397,29.8902768 107.975769,29.5802293 C107.662373,29.2701817 107.506059,28.8877637 107.506059,28.4337562 L107.506059,14.2460215 C107.506059,13.7925347 107.662373,13.4101166 107.975769,13.0995484 C108.288397,12.7892406 108.674057,12.6338263 109.131723,12.6338263 L119.970424,12.6338263 C120.692799,12.6338263 121.366742,12.7715384 121.993535,13.0456611 C122.619559,13.3205647 123.17332,13.6907474 123.655331,14.1564696 C124.137085,14.6221917 124.516338,15.171999 124.793347,15.8043294 C125.070355,16.4377011 125.208988,17.1122043 125.208988,17.8286198 L125.208988,28.4337562 C125.208988,28.8877637 125.046524,29.2701817 124.721084,29.5802293 C124.396156,29.8902768 124.016646,30.0459514 123.583324,30.0459514 C123.125401,30.0459514 122.739998,29.8902768 122.427114,29.5802293 C122.113717,29.2701817 121.957403,28.8877637 121.957403,28.4337562 L121.957403,17.8286198 C121.957403,17.2795935 121.764445,16.8138713 121.379298,16.4314533 C120.993639,16.0495559 120.524185,15.8582168 119.970424,15.8582168 L117.983188,15.8582168 L117.983188,28.4337562 C117.983188,28.8877637 117.820467,29.2701817 117.49554,29.5802293 C117.170356,29.8902768 116.791102,30.0459514 116.357523,30.0459514 C115.899601,30.0459514 115.514197,29.8902768 115.20157,29.5802293 C114.888173,29.2701817 114.731859,28.8877637 114.731859,28.4337562 L114.731859,15.8582168 L110.757644,15.8582168 Z"
                                                                id="Fill-18" fill="#333548"></path>
                                                            <path
                                                                d="M132.145684,28.4336521 C132.145684,28.8876596 131.988858,29.2700776 131.675974,29.5801252 C131.362577,29.890433 130.976918,30.0458473 130.519764,30.0458473 C130.062097,30.0458473 129.676438,29.890433 129.36381,29.5801252 C129.050414,29.2700776 128.8941,28.8876596 128.8941,28.4336521 L128.8941,14.1027384 C128.8941,13.6492516 129.050414,13.2668335 129.36381,12.9562653 C129.676438,12.6459574 130.062097,12.4905432 130.519764,12.4905432 C130.976918,12.4905432 131.362577,12.6459574 131.675974,12.9562653 C131.988858,13.2668335 132.145684,13.6492516 132.145684,14.1027384 L132.145684,28.4336521 Z M130.519764,10.6989837 C129.96549,10.6989837 129.49578,10.5081652 129.110889,10.1257472 C128.72523,9.74411014 128.532784,9.27812766 128.532784,8.72858073 C128.532784,8.17929412 128.72523,7.71357196 129.110889,7.33115394 C129.49578,6.9495169 129.96549,6.7579174 130.519764,6.7579174 C131.073525,6.7579174 131.543235,6.9495169 131.928895,7.33115394 C132.313786,7.71357196 132.507,8.17929412 132.507,8.72858073 C132.507,9.27812766 132.313786,9.74411014 131.928895,10.1257472 C131.543235,10.5081652 131.073525,10.6989837 130.519764,10.6989837 L130.519764,10.6989837 Z"
                                                                id="Fill-20" fill="#333548"></path>
                                                            <path
                                                                d="M138.287486,29.8308706 C137.58843,29.4250233 137.034669,28.875997 136.625691,28.1830108 C136.215687,27.4905452 136.011198,26.7496591 136.011198,25.9616541 L136.011198,6.93733367 C136.011198,6.48358648 136.173918,6.10142879 136.499102,5.79060025 C136.824286,5.48055269 137.203796,5.3248781 137.637118,5.3248781 C138.094272,5.3248781 138.479932,5.48055269 138.793328,5.79060025 C139.105956,6.10142879 139.263038,6.48358648 139.263038,6.93733367 L139.263038,25.9616541 C139.263038,26.4396115 139.479572,26.7980796 139.91315,27.0365377 C140.298297,27.2755164 140.550962,27.6040471 140.671913,28.021609 C140.792095,28.4396916 140.73162,28.8517867 140.491255,29.257634 C140.274466,29.6395314 139.949282,29.8847579 139.515703,29.992012 C139.082381,30.0995264 138.672377,30.0458994 138.287486,29.8308706"
                                                                id="Fill-22" fill="#333548"></path>
                                                            <g id="Group-26"
                                                                transform="translate(142.000000, 12.000000)"
                                                                fill="#333548">
                                                                <path
                                                                    d="M6.15019871,3.7149597 C5.59592515,3.7149597 5.12621483,3.90629887 4.74106773,4.28819625 C4.35566439,4.67035394 4.16296272,5.13633642 4.16296272,5.6853627 L4.16296272,7.65576571 L8.13717845,7.65576571 L8.13717845,5.6853627 C8.13717845,5.13633642 7.94422053,4.67035394 7.55907344,4.28819625 C7.17367009,3.90629887 6.70395977,3.7149597 6.15019871,3.7149597 M4.16296272,17.652001 C3.15153519,17.2458934 2.35664079,16.612782 1.77853578,15.7529272 C1.20068701,14.8930723 0.911634503,13.9257031 0.911634503,12.8508195 L0.911634503,5.6853627 C0.911634503,4.96894718 1.0500107,4.29444406 1.32701936,3.66107234 C1.60377176,3.0284816 1.9773875,2.47893467 2.44709783,2.01295219 C2.91680815,1.54723004 3.47056921,1.17730763 4.1088935,0.902404005 C4.74670528,0.628281352 5.42756744,0.490569212 6.15019871,0.490569212 C6.87257373,0.490569212 7.55317964,0.628281352 8.19150393,0.902404005 C8.82931571,1.17730763 9.38358927,1.54723004 9.8532996,2.01295219 C10.3230099,2.47893467 10.6961132,3.0284816 10.9731218,3.66107234 C11.2498742,4.29444406 11.3887629,4.96894718 11.3887629,5.6853627 L11.3887629,9.26822128 C11.3887629,9.72222879 11.2319366,10.1043865 10.9190526,10.4146944 C10.6059124,10.7252626 10.2202528,10.8804165 9.76309881,10.8804165 L4.16296272,10.8804165 L4.16296272,12.8508195 C4.16296272,13.2574478 4.27161366,13.6211224 4.48840304,13.9436656 C4.70493617,14.2662088 5.00577628,14.511175 5.39143588,14.6780436 C5.77632672,14.8214829 6.16198631,14.8571474 6.54764591,14.7855579 C6.93253675,14.7139685 7.27002093,14.5348646 7.55907344,14.247986 C7.8719574,13.9139885 8.25121069,13.7465992 8.69708956,13.7465992 C9.14271218,13.7465992 9.53375307,13.9139885 9.87123725,14.247986 C10.1841212,14.5830248 10.3409476,14.9646618 10.3409476,15.3947194 C10.3409476,15.8245166 10.1841212,16.2069347 9.87123725,16.5411925 C9.10043056,17.2818183 8.20329153,17.7530073 7.17982015,17.9563214 C6.15558001,18.1591149 5.15055879,18.057588 4.16296272,17.652001"
                                                                    id="Fill-24"></path>
                                                            </g>
                                                            <path
                                                                d="M71.0275301,22.6909777 C70.4827379,22.6909777 70.0209714,22.8836185 69.6427431,23.2683795 C69.263746,23.6531404 69.0746319,24.1219865 69.0746319,24.675178 C69.0746319,25.2286298 69.263746,25.6974758 69.6427431,26.0819765 C70.0209714,26.4669977 70.4827379,26.6591179 71.0275301,26.6591179 L72.9806845,26.6591179 L72.9806845,22.6909777 L71.0275301,22.6909777 Z M72.9806845,19.4441992 L72.9806845,17.5326298 C72.9806845,17.1481292 72.8740836,16.7930453 72.661138,16.4684195 C72.4479362,16.1435334 72.1640087,15.9092406 71.8088431,15.7650203 C71.4536775,15.6205397 71.0862119,15.5846148 70.7079836,15.6567249 C70.3289865,15.728835 70.00944,15.9092406 69.749344,16.1976811 C69.4415851,16.5105922 69.0684818,16.6665272 68.6305468,16.6665272 C68.1926117,16.6665272 67.8195085,16.5105922 67.5122621,16.1976811 C67.1804155,15.8613407 67.0151328,15.4763194 67.0151328,15.0433982 C67.0151328,14.6104771 67.1804155,14.2259765 67.5122621,13.8888551 C68.2459122,13.1438038 69.110251,12.6687099 70.1042533,12.4640941 C71.098512,12.259999 72.0689391,12.3620466 73.0163036,12.7707574 C73.9864745,13.179989 74.7562562,13.8112781 75.3243674,14.6646248 C75.8922223,15.5184921 76.1766623,16.474407 76.1766623,17.5326298 L76.1766623,28.2825071 C76.1766623,28.7393782 76.0221422,29.1246598 75.7148958,29.43679 C75.4068806,29.7489202 75.0278836,29.9058964 74.5784172,29.9058964 L71.0275301,29.9058964 C70.3174552,29.9058964 69.6483806,29.7671429 69.0213314,29.4909377 C68.394026,29.2147324 67.8497463,28.8416861 67.3879798,28.3725797 C66.9264695,27.9034733 66.5590038,27.3505422 66.2871202,26.7132656 C66.0147241,26.0762493 65.8789104,25.3965397 65.8789104,24.675178 C65.8789104,23.9538163 66.0147241,23.274367 66.2871202,22.63683 C66.5590038,22.0000741 66.9264695,21.4466223 67.3879798,20.9775159 C67.8497463,20.5084095 68.394026,20.1361442 69.0213314,19.8591579 C69.6483806,19.583213 70.3174552,19.4441992 71.0275301,19.4441992 L72.9806845,19.4441992 Z"
                                                                id="Fill-27" fill="#FEFEFE"></path>
                                                        </g>
                                                    </g>
                                                </g>
                                            </svg>
                                        </div>
                                        <br>
                                        <br>
                                        <div style="text-align:center; margin-bottom: 15px;">
                                            BookMyShow’s charity initiative BookASmile, was created with a vision to
                                            enrich the lives of the less fortunate through activities and experiences
                                            from across genres like Cinema, Sport, Theatre, Music &amp; Arts.
                                            <br>
                                        </div>
                                        <h3>Disclaimer</h3>
                                        <div class="__block">
                                            1. Big Tree Entertainment Pvt Ltd (BEPL) is facilitating the transactions on
                                            the platform<a target="_blank"
                                                href="https://in.bookmyshow.com/donation">https://in.bookmyshow.com/donation</a>.
                                            The proceeds of the same will be used for social initiatives for the
                                            underprivileged sections of society.<br><br>
                                            2. Apart from this, BEPL is not engaged in any partnership, association or
                                            tie-up with the NGOs. <br><br>
                                            3. BEPL expressly disclaims any and all liability and assumes no
                                            responsibility whatsoever for consequences resulting from any actions or
                                            inactions of the NGO.<br><br>
                                            4. By proceeding to donate the money, you do so at your own risk and
                                            expressly waive any and all claims, rights of action and/or remedies (under
                                            law or otherwise) that you may have against BEPL arising out of or in
                                            connection with the aforesaid transaction.<br><br>
                                            5. BEPL will not be held responsible for the issuance of 80G
                                            certificate.<br><br>
                                            6. The amount contributed towards BookASmile is purely a voluntary act of
                                            kindness to contribute to the smiles of the less fortunate. In case you have
                                            made the contribution to BookASmile by mistake, please reach out to us at<a
                                                target="_blank"
                                                href="https://support.bookmyshow.com/support/tickets/new">email</a> for
                                            a refund of the same. The refund shall be made into the same bank
                                            account/wallet/payment channel through which the contribution was made by
                                            you.<br><br>
                                            7. For any queries, kindly<a target="_blank"
                                                href="https://support.bookmyshow.com/support/tickets/new">email us</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <div class="gst_section" id="gstCurrentStateId" style="">
                        <p>Your current state is <span id="gst-str-state" onclick="fnChangeGSTState();">Delhi</span></p>
                    </div>
                </div>
                <div class="_total-section amt-payable">
                    <div>
                        Amount Payable
                    </div>
                    <div><span id="ttPrice" class="__amount-payable">Rs. 465.72</span></div>
                </div>
            </div>
            <div id="seatErr" class="form-messages"></div>
            <div class="ticket-type" id="TickType" style="display: none;">
                <h3>Select Ticket Type</h3>
                <div id="shmticket" style="display:none" onclick="dispTicketType(this);">
                    <input type="radio" id="mticket" name="tickettype">
                    <label for="mticket">
                        <span class="border-line"></span>
                        <span class="m-ticket-icon">
                            <svg width="100%" height="100%" version="1.1" xmlns="http://www.w3.org/2000/svg"
                                xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                enable-background="new 0 0 100 100" xml:space="preserve">
                                <use xlink:href="/icons/fnb-icons.svg#icon-M-Ticket"></use>
                            </svg>
                        </span>M-Ticket<br>
                        <!-- Download the m-Ticket on your mobile, no printout needed.  -->
                    </label>
                </div>
                <div id="shbox" style="display:none" onclick="dispTicketType(this);">

                    <input type="radio" id="box" name="tickettype" style="display:none">
                    <label for="box">
                        <span class="border-line"></span>
                        <span class="box-office-icon">
                            <svg width="100%" height="100%" version="1.1" xmlns="http://www.w3.org/2000/svg"
                                xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                enable-background="new 0 0 100 100" xml:space="preserve">
                                <use xlink:href="/icons/fnb-icons.svg#icon-Box-Office"></use>
                            </svg>
                        </span>Box Office Pickup<br>
                        <!-- Select this option to pick your tickets from Box Office -->
                    </label>
                </div><br>
                <div class="ticket-desc" style="display: none;"></div>
            </div>
            <div class="disclaimer-container">
                <div style="width: 13px; height: 13px;">
                    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                        x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
                        <use xlink:href="/icons/common-icons.svg#icon-info"></use>
                    </svg>
                </div>
                <div
                    style="font-family: Roboto; font-size: 12px; line-height: 16px; align-items: center; letter-spacing: 0.2px; color: #404040; margin-left: 5px;">
                    By proceeding, I express my consent to complete this transaction.
                </div>
            </div>
            <div class="button">
                <router-link to="/">
                <button class="btn btn-red">New Booking</button>
                </router-link>
            </div>
            <div class="cancellation-policy-cri">
                <span class="cancellation-policy-text"></span>
                <span class="cancellation-policy-link" onclick="fnDispCancellationRules();"></span>
            </div>
        </div>
    </div>
</section>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'PaymentPage',
    data () {
        return {
            ticketId : this.$route.query.ticketId
        }
    },
    beforeMount(){
        console.log(this.ticketId)
        axios.get('http://localhost:8081/api/ticket/'+this.ticketId)
            .then((response) => {
                console.log(response)
            })
            .catch((error) => {
                console.log(error)
        })
    }
  
  
};
</script>

<style>
.__event-name a {
    max-width: 500px;
    overflow: hidden;
        font-size: 14px;
    text-align: left;
    color: #fff;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.__event-details {
    font-size: 14px;
    text-align: left;
    color: #fff;
    float: left;
}
.__event-date-holder-one {
    display: none;
}
.btn-red {
    background-color: #c02c39;
    color: #fff;
    width:100%;
}
.bkf-layout .bkf-container._add-ons:not(._touch) {
    max-width: 1400px;
    width: 100%;
}
 .header-container {
    position: relative;
    zoom: 1;
    min-width: 320px;
    padding: 9px 0 9px 30px;
    background: #1f2533;
}
header h2 {
    font-size: 20px;
    color: #49ba8e;
    display: flex;
    flex-direction: column;
    margin-right: 20px;
    margin-left: 15px;
    float: left;
}
.bkf-layout .bkf-container .add-ons-container {
    width: 69%;
    float: left;
}
.bkf-layout .bkf-header h2 span.__event-name {
    max-width: 500px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
header h2 span {
    display: inline-block;
}
header h2 span.__event-name a {
    font-size: 14px;
    color: #fff;
}
header h2 .__event-details {
    max-width: 500px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    line-height: 18px;
    color: #c6c6c9;
    font-size: 12px;
    width: 100%;
}
header h2 span #strDate {
    display: inline-block!important;
}
.fnb-proceed-btn {
    margin-top: 10px;
    padding: 8px 0;
}
.bar-btn._full-width {
    width: 100%;
    padding: 10px 16px;
    justify-content: space-between;
}
.fnb-proceed-btn {
    margin-top: 10px;
    padding: 8px 0;
}
.btn {
    text-align: center;
    cursor: pointer;
    padding: 15px 40px;
    font-size: 12px;
    border-radius: 8px;
    outline: 0;
    border: none;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 2px;
    display: inline-block;
}
.__details li div span {
    font-size: 12px;
    color: #1f2533;
}
.btn._centered {
    margin: auto;
    justify-content: center;
}
.bar-btn._primary {
    background: #f84464;
    color: #fff;
}
.order-summary h2 {
    position: relative;
    font-size: 14px;
    font-weight: 300;
    text-transform: uppercase;
    letter-spacing: 3px;
    margin-bottom: 25px;
    text-align: left;
    color: #c02c39;
}
header h2 .__event-details span {
    font-weight: 700;
}
.__bas-additional-content{
    display: none;
}
.__bas-tnc-block-touch{
    display: none;
}
 .bkf-header h2 span {
    display: inline-block;
}
.bas-container {
    width: 100%;
    padding-top: 8px;
    position: relative;
}
.bas-wrapper {
    position: relative;
    height: 210px;
    color: #fff;
    overflow: hidden;
    background: #000;
}
.__cover-image {
    height: 100%;
    width: 100%;
    zoom: 1;
}
.__cover-image img {
    height: 100%;
    width: 100%;
    float: right;
}
.bkf-order-summary-container {
    margin-top: -116px;
    box-sizing: border-box;
    width: 30%;
    float: left;
}
.order-summarywrap {
    border: 1px solid #dfe3e7;
}
.order-summary {
    position: relative;
    padding: 30px 25px;
    background: #fff;
}
.__circle-left {
    left: -11px;
    box-shadow: inset -1px 0 0 #dfe3e7;
}
 .__circle-right {
    right: -11px;
    box-shadow: inset 1px 0 0 #dfe3e7;
}
ul {
    list-style: none;
}
li div:first-child {
    float: left;
}
.__sub-total {
    font-size: 14px;
}
 li div span {
    font-size: 12px;
    color: #1f2533;
}
 .__details li div span#audiInfo {
    color: #969696;
    padding-left: 20px;
}
div span.__seat-price {
    font-size: 14px;
}
.add-ons-container {
    width: 69%;
    float: left;
}
</style>
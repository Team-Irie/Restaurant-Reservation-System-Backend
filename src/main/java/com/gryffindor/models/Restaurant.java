package com.gryffindor.models;

public class Restaurant {
    private final String id;
    private final String name;
    private final String address1;
    private final String city;
    private final String state;
    private final String zip_code;
    private final String display_phone;

    public Restaurant(String id, String name, String address1, String city, String state, String zip_code, String display_phone) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.display_phone = display_phone;
    }

//    @Override
//    public String toString() {
//        return "Restaurant{" +
//                "id=" + id +
//                ", name=" + name +
//                ", address1" + address1 +
//                ", phone=" + phone +
//                "}";
//    }


    /*
*
* this is an example object sent by the yelp api
*
* {
            "id": "4yPqqJDJOQX69gC66YUDkA",
            "alias": "peter-luger-brooklyn-2",
            "name": "Peter Luger",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/sxnoGiAvhhk3__zO37IXNQ/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/peter-luger-brooklyn-2?adjust_creative=1hbKvhK-OTLntwxLKqv8LA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=1hbKvhK-OTLntwxLKqv8LA",
            "review_count": 6187,
            "categories": [
                {
                    "alias": "steak",
                    "title": "Steakhouses"
                }
            ],
            "rating": 4.0,
            "coordinates": {
                "latitude": 40.709945,
                "longitude": -73.962478
            },
            "transactions": [],
            "price": "$$$$",
            "location": {
                "address1": "178 Broadway",
                "address2": "",
                "address3": "",
                "city": "Brooklyn",
                "zip_code": "11211",
                "country": "US",
                "state": "NY",
                "display_address": [
                    "178 Broadway",
                    "Brooklyn, NY 11211"
                ]
            },
            "phone": "+17183877400",
            "display_phone": "(718) 387-7400",
            "distance": 1121.1660016942274
        }
*
* */
}

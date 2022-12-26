package com.example.bootio.app.web;

import com.example.bootio.app.model.RetailInterface;
import com.example.bootio.app.model.Usr;
import com.example.bootio.app.service.DataService;
import com.example.bootio.app.service.RetailService;
import com.example.bootio.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/data/")
public class DataController {

//    @Resource(name = "dataService")
//    private DataService dataService;

    private final DataService dataService;

    private final UserService todoService;

    private final RetailService retailService;

    // return jsonString
    @ResponseBody
    @RequestMapping(path = "superheroes.json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8" )
    public String test() {
//		{
//			  "result": true,
//			  "data": {
//			    "contents": [],
//			    "pagination": {
//			      "page": 1,
//			      "totalCount": 100
//			    }
//			  }
//			}

        String result =
                "{\"result\": true, \"data\" : { \"contents\": [{\"id\":549731,\"name\":\"Beautiful Lies\",\"artist\":\"Birdy\",\"release\":\"2016.03.26\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Pop\",\"genreCode\":\"1\",\"grade\":\"2\",\"price\":10000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":436461,\"name\":\"X\",\"artist\":\"Ed Sheeran\",\"release\":\"2014.06.24\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Pop\",\"genreCode\":\"1\",\"grade\":\"3\",\"price\":20000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":295651,\"name\":\"Moves Like Jagger\",\"release\":\"2011.08.08\",\"artist\":\"Maroon5\",\"type\":\"Single\",\"typeCode\":\"3\",\"genre\":\"Pop,Rock\",\"genreCode\":\"1,2\",\"grade\":\"2\",\"price\":7000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":541713,\"name\":\"A Head Full Of Dreams\",\"artist\":\"Coldplay\",\"release\":\"2015.12.04\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Rock\",\"genreCode\":\"2\",\"grade\":\"3\",\"price\":25000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":265289,\"name\":\"21\",\"artist\":\"Adele\",\"release\":\"2011.01.21\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Pop,R&B\",\"genreCode\":\"1,3\",\"grade\":\"3\",\"price\":15000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":555871,\"name\":\"Warm On A Cold Night\",\"artist\":\"HONNE\",\"release\":\"2016.07.22\",\"type\":\"EP\",\"typeCode\":\"1\",\"genre\":\"R&B,Electronic\",\"genreCode\":\"3,4\",\"grade\":\"2\",\"price\":11000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":550571,\"name\":\"Take Me To The Alley\",\"artist\":\"Gregory Porter\",\"release\":\"2016.09.02\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Jazz\",\"genreCode\":\"5\",\"grade\":\"3\",\"price\":30000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":544128,\"name\":\"Make Out\",\"artist\":\"LANY\",\"release\":\"2015.12.11\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Electronic\",\"genreCode\":\"4\",\"grade\":\"2\",\"price\":12000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":366374,\"name\":\"Get Lucky\",\"artist\":\"Daft Punk\",\"release\":\"2013.04.23\",\"type\":\"Single\",\"typeCode\":\"3\",\"genre\":\"Pop,Funk\",\"genreCode\":\"1,5\",\"grade\":\"3\",\"price\":9000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":8012747,\"name\":\"Valtari\",\"artist\":\"Sigur Rós\",\"release\":\"2012.05.31\",\"type\":\"EP\",\"typeCode\":\"3\",\"genre\":\"Rock\",\"genreCode\":\"2\",\"grade\":\"3\",\"price\":10000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":502792,\"name\":\"Bush\",\"artist\":\"Snoop Dogg\",\"release\":\"2015.05.12\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Hiphop\",\"genreCode\":\"5\",\"grade\":\"3\",\"price\":18000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":294574,\"name\":\"2\",\"artist\":\"Beyoncé\",\"release\":\"2011.07.26\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"Pop\",\"genreCode\":\"1\",\"grade\":\"3\",\"price\":12000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":317659,\"name\":\"I Won't Give Up\",\"artist\":\"Jason Mraz\",\"release\":\"2012.01.03\",\"type\":\"Single\",\"typeCode\":\"3\",\"genre\":\"Pop\",\"genreCode\":\"1\",\"grade\":\"2\",\"price\":7000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":583551,\"name\":\"Following My Intuition\",\"artist\":\"Craig David\",\"release\":\"2016.10.01\",\"type\":\"Deluxe\",\"typeCode\":\"1\",\"genre\":\"R&B,Electronic\",\"genreCode\":\"3,4\",\"grade\":\"3\",\"price\":15000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":490500,\"name\":\"Blue Skies\",\"release\":\"2015.03.18\",\"artist\":\"Lenka\",\"type\":\"Single\",\"typeCode\":\"3\",\"genre\":\"Pop,Rock\",\"genreCode\":\"1,2\",\"grade\":\"3\",\"price\":6000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":587871,\"name\":\"This Is Acting\",\"artist\":\"Sia\",\"release\":\"2016.10.22\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Pop\",\"genreCode\":\"1\",\"grade\":\"3\",\"price\":20000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":504288,\"name\":\"Blurryface\",\"artist\":\"Twenty One Pilots\",\"release\":\"2015.05.19\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Rock\",\"genreCode\":\"2\",\"grade\":\"1\",\"price\":13000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":450720,\"name\":\"I'm Not The Only One\",\"artist\":\"Sam Smith\",\"release\":\"2014.09.15\",\"type\":\"Single\",\"typeCode\":\"3\",\"genre\":\"Pop,R&B\",\"genreCode\":\"1,3\",\"grade\":\"2\",\"price\":8000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":498896,\"name\":\"The Magic Whip\",\"artist\":\"Blur\",\"release\":\"2015.04.27\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Rock\",\"genreCode\":\"2\",\"grade\":\"3\",\"price\":15000,\"downloadCount\":1000,\"listenCount\":5000},{\"id\":491379,\"name\":\"Chaos And The Calm\",\"artist\":\"James Bay\",\"release\":\"2015.03.23\",\"type\":\"EP\",\"typeCode\":\"2\",\"genre\":\"Pop,Rock\",\"genreCode\":\"1,2\",\"grade\":\"3\",\"price\":12000,\"downloadCount\":1000,\"listenCount\":5000}] }}"
                ;
        return result;
    }

    // JDBC connection programming
    @ResponseBody
    @RequestMapping(path = "retails.json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8" )
    public List<?> test2() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        return dataService.findAll(date);
    }

    // JPA with Entity
    @ResponseBody
    @RequestMapping(path = "users.json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8" )
    public List<Usr> test3() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        return todoService.findAll();
    }

    // JPA with Native query
    @ResponseBody
    @RequestMapping(path = "sales.json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8" )
    public List<RetailInterface> test4() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        return retailService.findAll(date);
    }
}

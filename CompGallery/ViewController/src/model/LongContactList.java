package model;

import java.text.DateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LongContactList {
    private static List<Contact> s_contacts = null;

    public LongContactList() 
    {
        if (s_contacts == null) {
            s_contacts = new ArrayList<Contact>();

          s_contacts.add(new Contact(1, "Bob", "Smith", "483 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(2, "Dan", "Jones", "838 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(3, "Julia", "Taylor", "615 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(4, "Bruce", "Williams", "862 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(5, "Kent", "Brown", "349 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(6, "Larry", "Davies", "520 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(7, "John", "Evans", "272 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(8, "Jane", "Wilson", "799 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(9, "Ted", "Thomas", "467 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(10, "Travis", "Roberts", "437 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(11, "Jack", "Johnson", "608 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(12, "Jerry", "Lewis", "823 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(13, "Bob", "Walker", "797 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(14, "Dan", "Robinson", "651 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(15, "Julia", "Wood", "617 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(16, "Bruce", "Thompson", "269 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(17, "Kent", "White", "346 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(18, "Larry", "Watson", "876 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(19, "John", "Jackson", "165 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(20, "Jane", "Wright", "169 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(21, "Ted", "Green", "405 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(22, "Travis", "Harris", "751 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(23, "Jack", "Cooper", "540 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(24, "Jerry", "King", "871 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(25, "Bob", "Lee", "634 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(26, "Dan", "Martin", "698 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(27, "Julia", "Clarke", "169 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(28, "Bruce", "James", "594 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(29, "Kent", "Morgan", "255 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(30, "Larry", "Hughes", "688 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(31, "John", "Edwards", "844 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(32, "Jane", "Hill", "723 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(33, "Ted", "Moore", "607 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(34, "Travis", "Clark", "900 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(35, "Jack", "Harrison", "392 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(36, "Jerry", "Scott", "153 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(37, "Bob", "Young", "216 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(38, "Dan", "Morris", "356 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(39, "Julia", "Hall", "244 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(40, "Bruce", "Ward", "110 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(41, "Kent", "Turner", "833 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(42, "Larry", "Carter", "754 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(43, "John", "Phillips", "239 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(44, "Jane", "Mitchell", "205 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(45, "Ted", "Patel", "185 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(46, "Travis", "Adams", "842 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(47, "Jack", "Campbell", "757 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(48, "Jerry", "Anderson", "444 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(49, "Bob", "Allen", "151 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(50, "Dan", "Cook", "700 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(51, "Julia", "Bailey", "205 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(52, "Bruce", "Parker", "509 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(53, "Kent", "Miller", "440 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(54, "Larry", "Davis", "250 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(55, "John", "Murphy", "485 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(56, "Jane", "Price", "429 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(57, "Ted", "Bell", "843 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(58, "Travis", "Baker", "364 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(59, "Jack", "Griffiths", "261 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(60, "Jerry", "Kelly", "611 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(61, "Bob", "Simpson", "534 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(62, "Dan", "Marshall", "389 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(63, "Julia", "Collins", "497 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(64, "Bruce", "Bennett", "450 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(65, "Kent", "Cox", "773 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(66, "Larry", "Richardson", "788 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(67, "John", "Fox", "360 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(68, "Jane", "Gray", "241 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(69, "Ted", "Rose", "401 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(70, "Travis", "Chapman", "673 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(71, "Jack", "Hunt", "712 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(72, "Jerry", "Robertson", "811 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(73, "Bob", "Shaw", "227 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(74, "Dan", "Reynolds", "164 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(75, "Julia", "Lloyd", "470 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(76, "Bruce", "Ellis", "452 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(77, "Kent", "Richards", "327 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(78, "Larry", "Russell", "640 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(79, "John", "Wilkinson", "688 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(80, "Jane", "Khan", "460 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(81, "Ted", "Graham", "216 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(82, "Travis", "Stewart", "522 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(83, "Jack", "Reid", "143 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(84, "Jerry", "Murray", "232 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(85, "Bob", "Powell", "623 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(86, "Dan", "Palmer", "645 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(87, "Julia", "Holmes", "614 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(88, "Bruce", "Rogers", "617 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(89, "Kent", "Stevens", "394 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(90, "Larry", "Walsh", "677 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(91, "John", "Hunter", "214 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(92, "Jane", "Thomson", "314 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(93, "Ted", "Matthews", "472 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(94, "Travis", "Ross", "122 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(95, "Jack", "Owen", "420 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(96, "Jerry", "Mason", "345 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(97, "Bob", "Knight", "142 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(98, "Dan", "Kennedy", "496 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(99, "Julia", "Butler", "636 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(100, "Bruce", "Saunders", "511 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(101, "Kent", "Cole", "394 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(102, "Larry", "Pearce", "179 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(103, "John", "Dean", "690 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(104, "Jane", "Foster", "886 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(105, "Ted", "Harvey", "175 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(106, "Travis", "Hudson", "170 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(107, "Jack", "Gibson", "661 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(108, "Jerry", "Mills", "304 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(109, "Bob", "Berry", "180 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(110, "Dan", "Barnes", "715 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(111, "Julia", "Pearson", "505 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(112, "Bruce", "Kaur", "586 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(113, "Kent", "Booth", "623 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(114, "Larry", "Dixon", "770 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(115, "John", "Grant", "555 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(116, "Jane", "Gordon", "622 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(117, "Ted", "Lane", "357 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(118, "Travis", "Harper", "837 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(119, "Jack", "Ali", "294 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(120, "Jerry", "Hart", "851 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(121, "Bob", "Mcdonald", "538 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(122, "Dan", "Brooks", "565 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(123, "Julia", "Ryan", "273 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(124, "Bruce", "Carr", "118 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(125, "Kent", "Macdonald", "226 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(126, "Larry", "Hamilton", "341 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(127, "John", "Johnston", "417 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(128, "Jane", "West", "539 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(129, "Ted", "Gill", "776 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(130, "Travis", "Dawson", "169 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(131, "Jack", "Armstrong", "270 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(132, "Jerry", "Gardner", "301 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(133, "Bob", "Stone", "132 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(134, "Dan", "Andrews", "255 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(135, "Julia", "Williamson", "767 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(136, "Bruce", "Barker", "449 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(137, "Kent", "George", "426 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(138, "Larry", "Fisher", "215 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(139, "John", "Cunningham", "272 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(140, "Jane", "Watts", "421 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(141, "Ted", "Webb", "627 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(142, "Travis", "Lawrence", "606 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(143, "Jack", "Bradley", "507 Anywhere Dr", "San Francisco", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(144, "Jerry", "Jenkins", "496 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(145, "Bob", "Wells", "307 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(146, "Dan", "Chambers", "218 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(147, "Julia", "Spencer", "803 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(148, "Bruce", "Poole", "857 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(149, "Kent", "Atkinson", "160 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
          s_contacts.add(new Contact(150, "Larry", "Lawson", "203 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));


          Collections.sort(s_contacts, new Comparator<Contact>() {
            public int compare(Contact o1,
                               Contact o2) {
          
            return o1.getLast().compareToIgnoreCase(o2.getLast());
          }
        });
        }
    }

    public List<Contact> getContacts() {
        return s_contacts;
    }

    public int getContactCount() {
        return s_contacts.size();
    }
}

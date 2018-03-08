package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThematicMapInvisibleAreaDataList {
    
    private static ArrayList<ThematicMapInvisibleAreaData> gdpModel;

    public ThematicMapInvisibleAreaDataList() {
        if(gdpModel == null) {
          gdpModel = new ArrayList<ThematicMapInvisibleAreaData>();
          
          gdpModel.add(new ThematicMapInvisibleAreaData("USA", 3960.397707301629, "15,684,750", "United States", 15684750, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CHN", 2868.281192630876, "8,227,037", "China", 8227037, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("JPN", 2442.1238707321954, "5,963,969", "Japan ", 5963969, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DEU", 1844.0658881938032, "3,400,579", "Germany ", 3400579, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("FRA", 1615.1467425593255, "2,608,699", "France", 2608699, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GBR", 1562.211573379227, "2,440,505", "United Kingdom", 2440505, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BRA", 1547.891469063642, "2,395,968", "Brazil ", 2395968, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("RUS", 1421.9563987689637, "2,021,960", "Russia", 2021960, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ITA", 1419.1825111661994, "2,014,079", "Italy  ", 2014079, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("IND", 1350.8634275899249, "1,824,832", "India", 1824832, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CAN", 1348.7331092547554, "1,819,081", "Canada", 1819081, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("AUS", 1241.6911854402447, "1,541,797", "Australia", 1541797, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ESP", 1162.7798587866923, "1,352,057", "Spain", 1352057, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MEX", 1084.9497684224832, "1,177,116", "Mexico", 1177116, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PRK", 1075.1148775828563, "1,155,872", "South Korea", 1155872, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("IDN", 937.1221905386725, "878,198", "Indonesia", 878198, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TUR", 891.3293442942401, "794,468", "Turkey", 794468, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NLD", 879.270151887348, "773,116", "Netherlands", 773116, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SAU", 852.8229593532294, "727,307", "Saudi Arabia", 727307, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CHE", 795.2358140828417, "632,400", "Switzerland", 632400, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("IRN", 740.8744832965973, "548,895", "Iran", 548895, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SWE", 725.3909290858275, "526,192", "Sweden", 526192, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NOR", 707.884877646076, "501,101", "Norway", 501101, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("POL", 698.336595060004, "487,674", "Poland", 487674, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BEL", 696.198247627786, "484,692", "Belgium", 484692, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ARG", 689.1690648890154, "474,954", "Argentina", 474954, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TWN", 688.4555178077957, "473,971", "Taiwan", 473971, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("AUT", 631.3430129493792, "398,594", "Austria", 398594, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ZAF", 619.9314478230638, "384,315", "South Africa", 384315, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("VEN", 618.4043984319646, "382,424", "Venezuela", 382424, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("COL", 604.9958677544831, "366,020", "Colombia", 366020, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("THA", 604.6188882262942, "365,564", "Thailand", 365564, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ARE", 599.1160154761346, "358,940", "United Arab Emirates", 358940, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DNK", 560.033034739916, "313,637", "Denmark", 313637, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MYS", 550.9328452724524, "303,527", "Malaysia", 303527, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SGP", 525.8516901180408, "276,520", "Singapore", 276520, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NGA", 518.3705238533533, "268,708", "Nigeria", 268708, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CHL", 517.858088669087, "268,177", "Chile", 268177, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("HKG", 512.8557302009991, "263,021", "Hong Kong", 263021, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("EGY", 506.6843198679035, "256,729", "Egypt", 256729, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PHL", 500.4358100695832, "250,436", "Philippines", 250436, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("FIN", 500.1259841279995, "250,126", "Finland", 250126, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GRC", 499.20036057679283, "249,201", "Greece", 249201, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ISR", 490.8095353596953, "240,894", "Israel", 240894, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PAK", 481.5381604815967, "231,879", "Pakistan", 231879, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PRT", 461.2157846388174, "212,720", "Portugal", 212720, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("IRQ", 460.9783075156574, "212,501", "Iraq", 212501, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("IRL", 458.7112381444344, "210,416", "Ireland", 210416, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DZA", 455.84427165425694, "207,794", "Algeria", 207794, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PER", 446.097522970034, "199,003", "Peru", 199003, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PRY", 446.097522970034, "199,003", "Paraguay", 199003, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KAZ", 443.1918320546984, "196,419", "Kazakhstan", 196419, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CZE", 442.8001806684365, "196,072", "Czech Republic", 196072, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("QAT", 428.2265755415, "183,378", "Qatar", 183378, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("UKR", 419.80352547352436, "176,235", "Ukraine", 176235, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KWT", 416.4420728024487, "173,424", "Kuwait", 173424, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ROU", 411.9223227745736, "169,680", "Romania", 169680, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NZL", 411.9223227745736, "169,680", "New Zealand", 169680, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("VNM", 371.57906291932005, "138,071", "Vietnam", 138071, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("HUN", 356.1923637586859, "126,873", "Hungary", 126873, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BGD", 350.31985384788, "122,724", "Bangladesh", 122724, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("AGO", 344.5562363388595, "118,719", "Angola", 118719, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("Mar", 312.2979346713647, "97,530", "Morocco", 97530, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SVK", 303.1765162409516, "91,916", "Slovakia", 91916, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LBY", 286.20796634615186, "81,915", "Libya", 81915, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ECU", 284.4767125794307, "80,927", "Ecuador", 80927, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("OMN", 276.52124692326987, "76,464", "Oman", 76464, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("AZE", 262.30516578977245, "68,804", "Azerbaijan", 68804, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BLR", 251.51341912510355, "63,259", "Belarus", 63259, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SDN", 244.82851141155925, "59,941", "Sudan", 59941, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LKA", 243.73756378531397, "59,408", "Sri Lanka", 59408, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DOM", 242.8909220205646, "58,996", "Dominican Republic", 58996, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("HRV", 238.96024774007915, "57,102", "Croatia", 57102, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LUX", 238.197397131035, "56,738", "Luxembourg", 56738, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MMR", 230.52114870440846, "53,140", "Burma", 53140, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("UZB", 226.20344824957908, "51,168", "Uzbekistan", 51168, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BGR", 225.8760722166029, "51,020", "Bulgaria", 51020, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GTM", 223.33830840229805, "49,880", "Guatemala", 49880, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("URY", 222.27010595219502, "49,404", "Uruguay", 49404, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SVN", 213.58136622842358, "45,617", "Slovenia", 45617, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TUN", 213.56731959735788, "45,611", "Tunisia", 45611, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CRI", 212.4476406082214, "45,134", "Costa Rica", 45134, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LTU", 205.33874451744367, "42,164", "Lithuania", 42164, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ETH", 204.7095503390108, "41,906", "Ethiopia", 41906, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LBN", 203.3346994489627, "41,345", "Lebanon", 41345, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KEN", 202.7732724004818, "41,117", "Kenya", 41117, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GHA", 197.3296733894829, "38,939", "Ghana", 38939, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SCG", 193.38821060240463, "37,399", "Serbia", 37399, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PAN", 190.40220586957494, "36,253", "Panama", 36253, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("YEM", 188.7882411592417, "35,641", "Yemen", 35641, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TKM", 183.51839144892264, "33,679", "Turkmenistan", 33679, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("JOR", 176.66069172286177, "31,209", "Jordan", 31209, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LVA", 168.46364592991569, "28,380", "Latvia", 28380, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TZA", 168.0684384410113, "28,247", "Tanzania", 28247, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BOL", 165.61702811003462, "27,429", "Bolivia", 27429, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BHR", 164.39586369492392, "27,026", "Bahrain", 27026, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TTO", 158.98742088605627, "25,277", "Trinidad and Tobago", 25277, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CMR", 158.12969360622944, "25,005", "Cameroon", 25005, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CIV", 156.9299206652447, "24,627", "C?te d'Ivoire", 24627, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SLV", 154.3243337908834, "23,816", "El Salvador", 23816, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CYP", 151.6772890053089, "23,006", "Cyprus", 23006, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("EST", 147.8614216082072, "21,863", "Estonia", 21863, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("UGA", 144.9206679531943, "21,002", "Uganda", 21002, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ZMB", 143.2375649052999, "20,517", "Zambia", 20517, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("AFG", 141.088624630053, "19,906", "Afghanista", 19906, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NPL", 139.33771922921662, "19,415", "Nepal", 19415, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("HND", 135.60235986147143, "18,388", "Honduras", 18388, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GAB", 135.55810562264435, "18,376", "Gabon", 18376, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("COD", 133.05262116922012, "17,703", "Congo, Democratic Republic of the", 17703, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BWA", 132.75541420220873, "17,624", "Botswana", 17624, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BIH", 131.6282644419503, "17,326", "Bosnia and Herzegovina", 17326, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GNQ", 131.1716432770437, "17,206", "Equatorial Guinea", 17206, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BRN", 128.94960255851896, "16,628", "Brunei", 16628, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GEO", 126.22994890278613, "15,934", "Georgia", 15934, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("PNG", 125.64234954823155, "15,786", "Papua New Guinea", 15786, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("JAM", 123.48684140425651, "15,249", "Jamaica", 15249, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MOZ", 120.83045973594572, "14,600", "Mozambique", 14600, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KHM", 119.33566105737212, "14,241", "Cambodia", 14241, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SEN", 117.74548823628021, "13,864", "Senegal", 13864, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("COG", 117.0128198104806, "13,692", "Congo, Republic of the", 13692, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ISL", 116.8503316212667, "13,654", "Iceland", 13654, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ALB", 112.64102272262978, "12,688", "Albania", 12688, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NAM", 110.90085662428402, "12,299", "Namibia", 12299, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SSD", 110.46266337545913, "12,202", "South Sudan", 12202, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MUS", 107.07940978544848, "11,466", "Mauritius", 11466, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TCD", 103.95191195932858, "10,806", "Chad", 10806, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BFA", 103.17945531936094, "10,646", "Burkina Faso", 10646, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NIC", 102.49878048055011, "10,506", "Nicaragua", 10506, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MLI", 101.58247880417174, "10,319", "Mali", 10319, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MNG", 101.28178513434683, "10,258", "Mongolia", 10258, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MDG", 100.58329881247681, "10,117", "Madagascar", 10117, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ARM", 100.32945728947207, "10,066", "Armenia", 10066, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ZWE", 99.00505037623081, "9,802", "Zimbabwe", 9802, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MKD", 98.3666610188635, "9,676", "Macedonia, Republic of", 9676, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LAO", 96.00520819205592, "9,217", "Laos", 9217, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MLT", 93.2148056909416, "8,689", "Malta", 8689, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BHS", 89.6827742657418, "8,043", "Bahamas, The", 8043, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("HTI", 88.89319434017432, "7,902", "Haiti", 7902, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TJK", 87.13208364316786, "7,592", "Tajikistan", 7592, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BEN", 86.19164692706596, "7,429", "Benin", 7429, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MDA", 85.15867542417507, "7,252", "Moldova", 7252, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("RWA", 84.98823447983844, "7,223", "Rwanda", 7223, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("NER", 81.08637370113428, "6,575", "Niger", 6575, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KGZ", 80.45495634204272, "6,473", "Kyrgyzstan", 6473, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GIN", 75.04665215717488, "5,632", "Guinea", 5632, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SUR", 68.83313155741209, "4,738", "Suriname", 4738, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BRB", 67.00746227100382, "4,490", "Barbados", 4490, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MNE", 65.4217089351845, "4,280", "Montenegro", 4280, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MWI", 64.89992295835181, "4,212", "Malawi", 4212, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MRT", 64.79969135728966, "4,199", "Mauritania", 4199, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TLS", 64.59876159803684, "4,173", "Timor-Leste", 4173, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("FJI", 63.21392251711643, "3,996", "Fiji", 3996, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SLE", 61.45730225123781, "3,777", "Sierra Leone", 3777, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SWZ", 61.24540799113024, "3,751", "Swaziland", 3751, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TGO", 60.70420084310476, "3,685", "Togo", 3685, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ERI", 55.60575509783138, "3,092", "Eritrea", 3092, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GUY", 52.80151512977634, "2,788", "Guyana", 2788, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BDI", 49.749371855331, "2,475", "Burundi", 2475, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LSO", 49.38623289946298, "2,439", "Lesotho", 2439, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("MDV", 47.0, "2,209", "Maldives", 2209, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BTN", 46.861498055439924, "2,196", "Bhutan", 2196, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CAF", 46.604720790924176, "2,172", "Central African Republic", 2172, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("CPV", 43.57751713900185, "1,899", "Cape Verde", 1899, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SMR", 43.069710934716056, "1,855", "San Marino", 1855, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LBR", 41.65333119931706, "1,735", "Liberia", 1735, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("BLZ", 39.42080668885405, "1,554", "Belize", 1554, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DJI", 36.796738985948195, "1,354", "Djibouti", 1354, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("LCA", 34.92849839314596, "1,220", "Saint Lucia", 1220, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("ATG", 34.292856398964496, "1,176", "Antigua and Barbuda", 1176, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SYC", 32.109188716004645, "1,031", "Seychelles", 1031, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("SLB", 31.78049716414141, "1,010", "Solomon Islands", 1010, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GMB", 30.298514815086232, "918", "Gambia, The", 918, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GNB", 29.49576240750525, "870", "Guinea-Bissau", 870, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("GRD", 28.106938645110393, "790", "Grenada", 790, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("VUT", 27.982137159266443, "783", "Vanuatu", 783, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KNA", 27.09243436828813, "734", "Saint Kitts and Nevis", 734, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("VCT", 26.68332812825267, "712", "Saint Vincent and the Grenadines", 712, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("WSM", 26.13426869074396, "683", "Samoa", 683, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("COM", 24.49489742783178, "600", "Comoros", 600, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("DMA", 22.293496809607955, "497", "Dominica", 497, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TON", 21.817424229271428, "476", "Tonga", 476, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("STP", 16.24807680927192, "264", "S?o Tom? and Pr?ncipe", 264, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("KIR", 13.152946437965905, "173", "Kiribati", 173, null));
          gdpModel.add(new ThematicMapInvisibleAreaData("TUV", 6.082762530298219, "37", "Tuvalu", 37, null));

          Collections.sort(gdpModel, new MapDataComparator());
          Collections.reverse(gdpModel);
        }
    }

    public List<ThematicMapInvisibleAreaData> getGlobalGDP() {
      return gdpModel;
    }
    
    public static class MapDataComparator implements Comparator<ThematicMapInvisibleAreaData> {
      public int compare(ThematicMapInvisibleAreaData data1, ThematicMapInvisibleAreaData data2) {
        return (data1.getValue() - data2.getValue());
      }
    }
    
      
      public static void main(String[] args) 
      {
        new ThematicMapInvisibleAreaDataList();
        
        System.out.println("    \"stockData\" : {");
        System.out.println("        \"collectionModel\" : {");
        System.out.println("            \".type\" : \"TreeBindings\",");
        System.out.println("            \"id\" : \"bindings.stockData\",");
        System.out.println("            \"treeNodeBindings\" : {");
        System.out.println("                \".type\" : \"TreeNodeBindings\",");
        System.out.print("                \"keys\" : [ ");
        for (int j = 0; j < gdpModel.size(); j++) {
          if (j == 0)
            System.out.print("\"" + j + "\"");
          else
            System.out.print(", \"" + j + "\"");
        }
        System.out.println(" ],");
        System.out.println("                \"providers\" : {");
        for (int j = 0; j < gdpModel.size(); j++) {
          ThematicMapInvisibleAreaData item = gdpModel.get(j);
          System.out.println("                    \"" + j + "\" : { \"countryName\" : \"" + item.getCountryName() + "\", \"formattedGDP\" : \"" 
                             + item.getFormattedGDP() + "\", \"id\" : \"" 
                             + item.getId()  + "\", \"sqrtGDP\" : " 
                             + item.getSqrtGDP() + ", \"value\" : " 
                             + item.getValue() +" },");
        }
        System.out.println("                }\n" + 
        "            }\n" + 
        "        }\n" + 
        "    }");
      }
    
}

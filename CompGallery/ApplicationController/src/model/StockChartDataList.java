package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

/**
 * Data list for dvtm:stockChart component
 * @author Michal Drozd (michal.drozd@oracle.com)
 */
public class StockChartDataList
{

  private static List<StockChartData> s_stockDataList = null;


  public StockChartDataList()
  {
    super();

    if (s_stockDataList == null)
    {
      s_stockDataList = new ArrayList<>();
      loadMax();
    }
  }

  private void loadMax()
  {
    s_stockDataList.add(new StockChartData(588.91, 591.0, 578.21, 589.6, 1407016800000L, 2803));
    s_stockDataList.add(new StockChartData(598.2, 607.2, 581.77, 583.54, 1406844000000L, 11940));
    s_stockDataList.add(new StockChartData(563.84, 586.0, 557.12, 585.93, 1406671200000L, 10499));
    s_stockDataList.add(new StockChartData(586.53, 596.0, 570.5, 592.61, 1406498400000L, 10540));
    s_stockDataList.add(new StockChartData(596.23, 603.0, 590.0, 602.93, 1406325600000L, 3608));
    s_stockDataList.add(new StockChartData(601.66, 621.99, 591.12, 620.95, 1406152800000L, 10241));
    s_stockDataList.add(new StockChartData(618.26, 624.99, 618.26, 622.63, 1405980000000L, 3364));
    s_stockDataList.add(new StockChartData(627.0, 630.0, 620.0, 630.0, 1405807200000L, 1468));
    s_stockDataList.add(new StockChartData(632.6, 632.96, 618.46, 626.3, 1405634400000L, 5026));
    s_stockDataList.add(new StockChartData(616.86, 625.0, 610.01, 622.9, 1405461600000L, 5349));
    s_stockDataList.add(new StockChartData(621.17, 632.0, 616.84, 630.88, 1405288800000L, 3827));
    s_stockDataList.add(new StockChartData(638.1, 642.57, 628.7, 634.99, 1405116000000L, 3794));
    s_stockDataList.add(new StockChartData(616.87, 623.93, 607.9, 621.96, 1404943200000L, 6336));
    s_stockDataList.add(new StockChartData(623.98, 626.22, 616.89, 622.09, 1404770400000L, 2675));
    s_stockDataList.add(new StockChartData(630.57, 639.0, 622.86, 630.9, 1404597600000L, 3335));
    s_stockDataList.add(new StockChartData(629.0, 650.48, 616.3, 648.48, 1404424800000L, 8739));
    s_stockDataList.add(new StockChartData(650.5, 658.75, 638.0, 638.25, 1404252000000L, 5306));
    s_stockDataList.add(new StockChartData(641.11, 647.09, 595.51, 599.86, 1404079200000L, 15516));
    s_stockDataList.add(new StockChartData(589.56, 604.21, 589.56, 599.99, 1403906400000L, 3085));
    s_stockDataList.add(new StockChartData(579.99, 580.11, 557.2, 560.4, 1403733600000L, 4675));
    s_stockDataList.add(new StockChartData(572.62, 588.25, 572.1, 588.22, 1403560800000L, 6502));
    s_stockDataList.add(new StockChartData(600.34, 605.05, 587.82, 591.33, 1403388000000L, 3857));
    s_stockDataList.add(new StockChartData(588.02, 598.68, 580.51, 593.41, 1403215200000L, 6710));
    s_stockDataList.add(new StockChartData(607.0, 616.0, 599.9, 606.48, 1403042400000L, 6745));
    s_stockDataList.add(new StockChartData(586.91, 610.0, 582.01, 592.0, 1402869600000L, 10768));
    s_stockDataList.add(new StockChartData(566.58, 593.53, 538.38, 592.0, 1402696800000L, 16568));
    s_stockDataList.add(new StockChartData(569.1, 630.36, 550.0, 623.81, 1402524000000L, 24822));
    s_stockDataList.add(new StockChartData(648.55, 657.41, 642.45, 648.83, 1402351200000L, 5910));
    s_stockDataList.add(new StockChartData(658.0, 661.11, 651.7, 657.13, 1402178400000L, 2601));
    s_stockDataList.add(new StockChartData(647.16, 662.13, 647.16, 661.46, 1402005600000L, 6452));
    s_stockDataList.add(new StockChartData(640.59, 673.61, 621.86, 668.9, 1401832800000L, 17376));
    s_stockDataList.add(new StockChartData(661.22, 678.0, 613.03, 630.99, 1401660000000L, 20087));
    s_stockDataList.add(new StockChartData(627.8, 628.5, 611.0, 621.0, 1401487200000L, 9697));
    s_stockDataList.add(new StockChartData(572.37, 582.1, 560.05, 580.66, 1401314400000L, 8110));
    s_stockDataList.add(new StockChartData(572.7, 595.0, 550.22, 581.87, 1401141600000L, 19805));
    s_stockDataList.add(new StockChartData(573.9, 586.34, 527.09, 528.44, 1400968800000L, 19783));
    s_stockDataList.add(new StockChartData(523.77, 547.1, 518.55, 529.99, 1400796000000L, 19620));
    s_stockDataList.add(new StockChartData(493.98, 499.1, 487.11, 489.0, 1400623200000L, 7112));
    s_stockDataList.add(new StockChartData(448.34, 450.0, 441.44, 446.91, 1400450400000L, 4723));
    s_stockDataList.add(new StockChartData(449.06, 451.48, 445.01, 447.55, 1400277600000L, 2295));
    s_stockDataList.add(new StockChartData(446.0, 452.67, 444.02, 444.07, 1400104800000L, 5496));
    s_stockDataList.add(new StockChartData(439.12, 442.75, 430.61, 442.48, 1399932000000L, 5970));
    s_stockDataList.add(new StockChartData(440.0, 458.2, 429.6, 457.7, 1399759200000L, 8864));
    s_stockDataList.add(new StockChartData(452.37, 457.08, 437.71, 439.6, 1399586400000L, 8282));
    s_stockDataList.add(new StockChartData(440.0, 452.0, 425.67, 429.0, 1399413600000L, 13248));
    s_stockDataList.add(new StockChartData(433.0, 445.0, 425.0, 435.88, 1399240800000L, 8188));
    s_stockDataList.add(new StockChartData(439.0, 454.5, 431.0, 452.0, 1399068000000L, 7432));
    s_stockDataList.add(new StockChartData(460.97, 465.88, 447.97, 449.0, 1398895200000L, 9556));
    s_stockDataList.add(new StockChartData(448.0, 454.47, 432.02, 440.41, 1398722400000L, 13845));
    s_stockDataList.add(new StockChartData(430.0, 461.97, 429.95, 459.22, 1398549600000L, 9312));
    s_stockDataList.add(new StockChartData(466.52, 503.99, 438.05, 502.15, 1398376800000L, 33417));
    s_stockDataList.add(new StockChartData(492.0, 495.2, 484.61, 490.0, 1398204000000L, 5696));
    s_stockDataList.add(new StockChartData(496.74, 515.0, 490.0, 501.07, 1398031200000L, 8377));
    s_stockDataList.add(new StockChartData(503.8, 507.43, 472.81, 482.1, 1397858400000L, 10269));
    s_stockDataList.add(new StockChartData(500.09, 533.8, 481.63, 529.26, 1397685600000L, 20053));
    s_stockDataList.add(new StockChartData(521.0, 528.75, 453.16, 459.99, 1397512800000L, 32622));
    s_stockDataList.add(new StockChartData(416.3, 427.75, 397.16, 424.91, 1397340000000L, 11018));
    s_stockDataList.add(new StockChartData(423.0, 432.22, 339.79, 363.1, 1397167200000L, 42125));
    s_stockDataList.add(new StockChartData(441.69, 457.3, 438.08, 453.57, 1396994400000L, 8007));
    s_stockDataList.add(new StockChartData(447.11, 464.19, 446.0, 459.97, 1396821600000L, 7419));
    s_stockDataList.add(new StockChartData(464.8, 464.8, 441.25, 450.0, 1396648800000L, 6467));
    s_stockDataList.add(new StockChartData(451.03, 465.0, 416.11, 438.9, 1396476000000L, 26945));
    s_stockDataList.add(new StockChartData(478.98, 509.98, 452.04, 454.81, 1396303200000L, 22905));
    s_stockDataList.add(new StockChartData(460.0, 492.0, 436.0, 491.99, 1396134000000L, 31437));
    s_stockDataList.add(new StockChartData(502.01, 532.0, 468.3, 475.0, 1395961200000L, 34960));
    s_stockDataList.add(new StockChartData(581.49, 592.0, 565.0, 583.77, 1395788400000L, 10310));
    s_stockDataList.add(new StockChartData(585.99, 592.6, 547.0, 558.22, 1395615600000L, 13674));
    s_stockDataList.add(new StockChartData(565.31, 571.99, 541.0, 569.99, 1395442800000L, 13614));
    s_stockDataList.add(new StockChartData(587.98, 611.3, 578.66, 610.01, 1395270000000L, 10907));
    s_stockDataList.add(new StockChartData(612.0, 624.17, 591.13, 622.97, 1395097200000L, 14908));
    s_stockDataList.add(new StockChartData(634.99, 639.39, 629.02, 637.58, 1394924400000L, 3297));
    s_stockDataList.add(new StockChartData(630.42, 645.0, 625.29, 641.02, 1394751600000L, 8677));
    s_stockDataList.add(new StockChartData(634.95, 656.95, 628.8, 631.72, 1394578800000L, 12741));
    s_stockDataList.add(new StockChartData(629.39, 646.59, 609.0, 638.4, 1394406000000L, 13350));
    s_stockDataList.add(new StockChartData(620.0, 639.79, 604.5, 632.79, 1394233200000L, 9699));
    s_stockDataList.add(new StockChartData(669.57, 675.71, 650.0, 669.0, 1394060400000L, 10405));
    s_stockDataList.add(new StockChartData(673.0, 702.24, 633.64, 677.69, 1393887600000L, 28031));
    s_stockDataList.add(new StockChartData(566.24, 570.99, 553.0, 567.46, 1393714800000L, 6437));
    s_stockDataList.add(new StockChartData(551.89, 591.39, 541.0, 584.7, 1393542000000L, 22634));
    s_stockDataList.add(new StockChartData(585.24, 610.0, 530.0, 534.34, 1393369200000L, 49111));
    s_stockDataList.add(new StockChartData(535.49, 629.0, 514.02, 609.9, 1393196400000L, 51841));
    s_stockDataList.add(new StockChartData(610.88, 619.88, 562.15, 581.35, 1393023600000L, 18076));
    s_stockDataList.add(new StockChartData(561.86, 631.0, 560.9, 623.01, 1392850800000L, 34967));
    s_stockDataList.add(new StockChartData(627.7, 650.0, 609.99, 633.66, 1392678000000L, 14834));
    s_stockDataList.add(new StockChartData(621.0, 670.0, 590.01, 655.83, 1392505200000L, 26398));
    s_stockDataList.add(new StockChartData(669.0, 712.9, 538.01, 609.4, 1392332400000L, 68378));
    s_stockDataList.add(new StockChartData(651.99, 685.19, 631.58, 677.0, 1392159600000L, 15512));
    s_stockDataList.add(new StockChartData(687.81, 713.0, 530.0, 688.0, 1391986800000L, 71861));
    s_stockDataList.add(new StockChartData(680.49, 723.0, 662.01, 705.01, 1391814000000L, 13501));
    s_stockDataList.add(new StockChartData(763.99, 803.0, 752.0, 780.01, 1391641200000L, 20653));
    s_stockDataList.add(new StockChartData(802.99, 812.98, 796.83, 806.99, 1391468400000L, 7592));
    s_stockDataList.add(new StockChartData(814.99, 825.21, 810.23, 813.23, 1391295600000L, 4076));
    s_stockDataList.add(new StockChartData(803.0, 809.98, 791.0, 799.99, 1391122800000L, 7728));
    s_stockDataList.add(new StockChartData(794.21, 804.95, 781.99, 785.51, 1390950000000L, 7045));
    s_stockDataList.add(new StockChartData(751.95, 823.0, 725.0, 814.67, 1390777200000L, 25194));
    s_stockDataList.add(new StockChartData(806.8, 817.0, 773.4, 780.0, 1390604400000L, 8706));
    s_stockDataList.add(new StockChartData(812.0, 823.28, 801.1, 819.2, 1390431600000L, 7395));
    s_stockDataList.add(new StockChartData(824.89, 834.5, 814.0, 826.02, 1390258800000L, 7670));
    s_stockDataList.add(new StockChartData(842.07, 842.07, 791.01, 810.0, 1390086000000L, 8418));
    s_stockDataList.add(new StockChartData(797.2, 821.0, 765.0, 814.4, 1389913200000L, 17115));
    s_stockDataList.add(new StockChartData(841.14, 850.26, 805.18, 815.99, 1389740400000L, 12268));
    s_stockDataList.add(new StockChartData(823.0, 844.05, 783.11, 844.04, 1389567600000L, 19366));
    s_stockDataList.add(new StockChartData(896.59, 909.96, 849.51, 851.63, 1389394800000L, 16131));
    s_stockDataList.add(new StockChartData(824.76, 848.0, 779.78, 823.94, 1389222000000L, 25302));
    s_stockDataList.add(new StockChartData(785.0, 943.0, 785.0, 915.8, 1389049200000L, 34064));
    s_stockDataList.add(new StockChartData(905.0, 948.0, 826.07, 828.79, 1388876400000L, 24076));
    s_stockDataList.add(new StockChartData(809.4, 818.99, 767.62, 784.19, 1388703600000L, 14860));
    s_stockDataList.add(new StockChartData(754.9, 757.99, 729.01, 732.0, 1388530800000L, 7908));
    s_stockDataList.add(new StockChartData(736.51, 740.0, 722.81, 728.01, 1388358000000L, 6600));
    s_stockDataList.add(new StockChartData(715.0, 736.01, 682.22, 723.98, 1388185200000L, 13385));
    s_stockDataList.add(new StockChartData(747.0, 764.32, 677.57, 679.01, 1388012400000L, 28029));
    s_stockDataList.add(new StockChartData(652.99, 668.8, 628.11, 654.76, 1387839600000L, 12796));
    s_stockDataList.add(new StockChartData(612.66, 690.0, 575.61, 595.07, 1387666800000L, 17673));
    s_stockDataList.add(new StockChartData(610.0, 719.97, 570.0, 685.1, 1387494000000L, 40960));
    s_stockDataList.add(new StockChartData(520.0, 680.7, 382.21, 675.0, 1387321200000L, 137070));
    s_stockDataList.add(new StockChartData(691.0, 864.0, 651.34, 861.98, 1387148400000L, 58807));
    s_stockDataList.add(new StockChartData(850.78, 895.0, 841.01, 888.47, 1386975600000L, 7427));
    s_stockDataList.add(new StockChartData(871.22, 898.9, 832.01, 879.04, 1386802800000L, 13974));
    s_stockDataList.add(new StockChartData(979.23, 989.6, 895.01, 899.91, 1386630000000L, 22695));
    s_stockDataList.add(new StockChartData(787.0, 797.0, 651.0, 693.3, 1386457200000L, 27465));
    s_stockDataList.add(new StockChartData(814.91, 1033.13, 796.73, 1020.51, 1386284400000L, 52689));
    s_stockDataList.add(new StockChartData(1132.01, 1153.27, 1052.1, 1055.0, 1386111600000L, 14434));
    s_stockDataList.add(new StockChartData(1047.47, 1057.0, 925.16, 955.0, 1385938800000L, 31517));
    s_stockDataList.add(new StockChartData(1119.52, 1163.0, 1080.0, 1131.99, 1385766000000L, 12908));
    s_stockDataList.add(new StockChartData(1012.98, 1050.18, 931.0, 963.98, 1385593200000L, 36899));
    s_stockDataList.add(new StockChartData(916.3, 919.0, 801.0, 811.95, 1385420400000L, 29793));
    s_stockDataList.add(new StockChartData(800.05, 842.78, 747.0, 829.15, 1385247600000L, 20131));
    s_stockDataList.add(new StockChartData(795.0, 799.8, 683.2, 720.0, 1385074800000L, 25125));
    s_stockDataList.add(new StockChartData(599.0, 619.0, 440.0, 536.01, 1384902000000L, 57712));
    s_stockDataList.add(new StockChartData(669.01, 669.55, 471.23, 478.1, 1384729200000L, 57089));
    s_stockDataList.add(new StockChartData(434.53, 447.47, 406.92, 412.07, 1384556400000L, 17983));
    s_stockDataList.add(new StockChartData(416.95, 421.97, 381.0, 393.5, 1384383600000L, 31638));
    s_stockDataList.add(new StockChartData(354.96, 357.0, 340.01, 343.63, 1384210800000L, 19748));
    s_stockDataList.add(new StockChartData(323.0, 341.24, 265.01, 341.24, 1384038000000L, 67237));
    s_stockDataList.add(new StockChartData(334.0, 334.45, 288.81, 291.0, 1383865200000L, 40186));
    s_stockDataList.add(new StockChartData(263.24, 265.0, 241.11, 242.9, 1383692400000L, 40027));
    s_stockDataList.add(new StockChartData(226.83, 230.4, 207.22, 210.0, 1383519600000L, 28262));
    s_stockDataList.add(new StockChartData(204.86, 205.15, 201.2, 202.14, 1383346800000L, 6600));
    s_stockDataList.add(new StockChartData(203.54, 203.75, 195.1, 197.58, 1383174000000L, 13741));
    s_stockDataList.add(new StockChartData(204.69, 205.0, 195.32, 196.62, 1383001200000L, 16745));
    s_stockDataList.add(new StockChartData(194.0, 195.0, 179.5, 180.39, 1382824800000L, 10096));
    s_stockDataList.add(new StockChartData(186.6, 194.0, 167.67, 194.0, 1382652000000L, 32780));
    s_stockDataList.add(new StockChartData(203.96, 203.96, 185.0, 189.74, 1382479200000L, 24326));
    s_stockDataList.add(new StockChartData(180.13, 181.93, 166.05, 166.6, 1382306400000L, 33108));
    s_stockDataList.add(new StockChartData(166.0, 172.0, 152.44, 152.89, 1382133600000L, 37967));
    s_stockDataList.add(new StockChartData(143.94, 145.0, 135.0, 137.54, 1381960800000L, 16767));
    s_stockDataList.add(new StockChartData(142.76, 147.39, 134.09, 135.43, 1381788000000L, 22232));
    s_stockDataList.add(new StockChartData(132.82, 133.0, 127.57, 127.58, 1381615200000L, 12574));
    s_stockDataList.add(new StockChartData(127.38, 127.42, 125.93, 126.8, 1381442400000L, 7867));
    s_stockDataList.add(new StockChartData(125.9, 127.99, 122.3, 124.5, 1381269600000L, 18934));
    s_stockDataList.add(new StockChartData(123.5, 124.49, 120.11, 122.49, 1381096800000L, 11885));
    s_stockDataList.add(new StockChartData(121.2, 122.29, 121.11, 121.94, 1380924000000L, 2943));
    s_stockDataList.add(new StockChartData(117.63, 118.79, 102.0, 103.85, 1380751200000L, 26113));
    s_stockDataList.add(new StockChartData(127.33, 127.93, 125.54, 126.25, 1380578400000L, 7514));
    s_stockDataList.add(new StockChartData(127.01, 128.8, 126.08, 126.5, 1380405600000L, 6745));
    s_stockDataList.add(new StockChartData(126.95, 126.96, 124.35, 124.85, 1380232800000L, 12117));
    s_stockDataList.add(new StockChartData(123.25, 125.0, 123.23, 123.75, 1380060000000L, 8053));
    s_stockDataList.add(new StockChartData(122.63, 123.99, 121.54, 123.27, 1379887200000L, 7737));
    s_stockDataList.add(new StockChartData(123.39, 124.1, 121.7, 122.92, 1379714400000L, 4154));
    s_stockDataList.add(new StockChartData(124.18, 127.95, 123.02, 127.0, 1379541600000L, 10236));
    s_stockDataList.add(new StockChartData(126.92, 127.69, 125.47, 126.28, 1379368800000L, 8853));
    s_stockDataList.add(new StockChartData(125.36, 126.25, 123.0, 124.49, 1379196000000L, 5361));
    s_stockDataList.add(new StockChartData(127.71, 128.79, 125.05, 126.38, 1379023200000L, 9310));
    s_stockDataList.add(new StockChartData(127.55, 127.72, 118.0, 122.08, 1378850400000L, 18550));
    s_stockDataList.add(new StockChartData(121.68, 124.13, 115.0, 118.37, 1378677600000L, 21346));
    s_stockDataList.add(new StockChartData(119.93, 122.16, 115.5, 116.56, 1378504800000L, 9677));
    s_stockDataList.add(new StockChartData(122.5, 127.5, 116.07, 121.65, 1378332000000L, 19237));
    s_stockDataList.add(new StockChartData(129.18, 131.0, 127.0, 129.4, 1378159200000L, 11995));
    s_stockDataList.add(new StockChartData(130.66, 132.09, 126.79, 127.9, 1377986400000L, 8022));
    s_stockDataList.add(new StockChartData(124.86, 126.14, 118.04, 118.91, 1377813600000L, 17374));
    s_stockDataList.add(new StockChartData(117.91, 119.63, 117.04, 117.74, 1377640800000L, 10196));
    s_stockDataList.add(new StockChartData(111.9, 113.3, 110.27, 113.12, 1377468000000L, 10843));
    s_stockDataList.add(new StockChartData(109.15, 110.33, 106.64, 107.91, 1377295200000L, 4333));
    s_stockDataList.add(new StockChartData(109.12, 113.02, 107.98, 111.52, 1377122400000L, 12232));
    s_stockDataList.add(new StockChartData(104.87, 104.88, 100.38, 102.85, 1376949600000L, 11513));
    s_stockDataList.add(new StockChartData(99.3, 99.99, 98.41, 99.71, 1376776800000L, 2758));
    s_stockDataList.add(new StockChartData(98.25, 99.0, 96.5, 98.09, 1376604000000L, 9306));
    s_stockDataList.add(new StockChartData(99.19, 101.0, 97.03, 97.75, 1376431200000L, 17998));
    s_stockDataList.add(new StockChartData(95.35, 96.18, 93.31, 94.0, 1376258400000L, 7204));
    s_stockDataList.add(new StockChartData(93.51, 94.25, 92.14, 92.72, 1376085600000L, 3115));
    s_stockDataList.add(new StockChartData(94.27, 97.14, 91.11, 97.09, 1375912800000L, 14017));
    s_stockDataList.add(new StockChartData(97.69, 98.98, 97.07, 97.88, 1375740000000L, 9249));
    s_stockDataList.add(new StockChartData(96.38, 96.61, 95.5, 95.54, 1375567200000L, 3020));
    s_stockDataList.add(new StockChartData(95.85, 98.71, 93.03, 96.63, 1375394400000L, 15553));
    s_stockDataList.add(new StockChartData(98.28, 101.0, 95.0, 96.98, 1375221600000L, 17025));
    s_stockDataList.add(new StockChartData(93.39, 93.5, 90.54, 92.72, 1375048800000L, 10251));
    s_stockDataList.add(new StockChartData(88.16, 90.16, 87.8, 89.97, 1374876000000L, 3489));
    s_stockDataList.add(new StockChartData(90.16, 90.66, 87.08, 88.42, 1374703200000L, 10417));
    s_stockDataList.add(new StockChartData(86.98, 88.88, 82.0, 85.59, 1374530400000L, 13039));
    s_stockDataList.add(new StockChartData(85.93, 86.99, 84.25, 85.02, 1374357600000L, 2908));
    s_stockDataList.add(new StockChartData(86.51, 88.0, 83.21, 85.0, 1374184800000L, 8690));
    s_stockDataList.add(new StockChartData(90.97, 92.37, 89.0, 91.61, 1374012000000L, 7405));
    s_stockDataList.add(new StockChartData(93.78, 95.0, 88.11, 90.02, 1373839200000L, 13031));
    s_stockDataList.add(new StockChartData(91.67, 92.04, 87.15, 90.19, 1373666400000L, 6005));
    s_stockDataList.add(new StockChartData(87.13, 89.96, 83.85, 86.13, 1373493600000L, 17311));
    s_stockDataList.add(new StockChartData(75.01, 76.01, 70.25, 74.0, 1373320800000L, 15909));
    s_stockDataList.add(new StockChartData(73.96, 73.96, 64.5, 66.34, 1373148000000L, 6859));
    s_stockDataList.add(new StockChartData(66.93, 79.4, 63.26, 79.4, 1372975200000L, 32935));
    s_stockDataList.add(new StockChartData(77.01, 89.56, 75.11, 88.04, 1372802400000L, 20741));
    s_stockDataList.add(new StockChartData(84.5, 90.16, 80.94, 89.41, 1372629600000L, 20854));
    s_stockDataList.add(new StockChartData(88.98, 91.61, 86.2, 89.2, 1372456800000L, 4374));
    s_stockDataList.add(new StockChartData(96.31, 98.76, 96.0, 98.75, 1372284000000L, 4937));
    s_stockDataList.add(new StockChartData(97.87, 101.0, 97.47, 98.83, 1372111200000L, 5294));
    s_stockDataList.add(new StockChartData(100.41, 101.45, 98.5, 100.0, 1371938400000L, 1977));
    s_stockDataList.add(new StockChartData(101.8, 104.86, 90.0, 103.0, 1371765600000L, 12332));
    s_stockDataList.add(new StockChartData(105.24, 107.5, 102.0, 104.49, 1371592800000L, 5484));
    s_stockDataList.add(new StockChartData(100.0, 101.47, 98.29, 98.74, 1371420000000L, 4786));
    s_stockDataList.add(new StockChartData(99.42, 105.0, 96.22, 99.01, 1371247200000L, 4243));
    s_stockDataList.add(new StockChartData(102.0, 108.43, 95.0, 106.1, 1371074400000L, 8047));
    s_stockDataList.add(new StockChartData(107.36, 108.0, 102.97, 104.21, 1370901600000L, 5234));
    s_stockDataList.add(new StockChartData(100.17, 110.0, 90.0, 109.11, 1370728800000L, 30734));
    s_stockDataList.add(new StockChartData(110.18, 119.16, 107.0, 118.78, 1370556000000L, 18261));
    s_stockDataList.add(new StockChartData(121.2, 122.74, 119.65, 120.58, 1370383200000L, 4733));
    s_stockDataList.add(new StockChartData(123.22, 125.01, 117.0, 123.35, 1370210400000L, 8850));
  }

  public List<StockChartData> getStockChartData()
  {
    return s_stockDataList;
  }

  public int getStockChartDataCount()
  {
    return s_stockDataList.size();
  }

  public void refreshChart(ActionEvent actionEvent)
  {
    // Add event code here...
    s_stockDataList.clear();

    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.stockDataIterator}", Object.class);
    AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding) ve.getValue(AdfmfJavaUtilities.getELContext());
    BasicIterator bi = aib.getIterator();

    bi.refresh(true);
  }

  public void SelectionListener(SelectionEvent event)
  {
    AdfmfJavaUtilities.setELValue("#{pageFlowScope.footnote}", "You selected item!");

  }

  public void DataListener(ValueChangeEvent valueChangeEvent)
  {
    String value = AdfmfJavaUtilities.getELValue("#{pageFlowScope.data}").toString();
    switch (value)
    {
      case "max":
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", "1370210400000");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", "1407016800000");
        break;
      case "year":
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", "1375480800000");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", "1407016800000");
        break;
      case "3month":
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", "1399068000000");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", "1407016800000");
        break;
      case "month":
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", "1404338400000");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", "1407016800000");
        break;
      case "week":
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", "1406325600000");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", "1407016800000");
        break;
    }
  }

  public void ViewportListener(oracle.adfmf.amx.event.ViewportChangeEvent event)
  {
   // AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMinValue}", event.getXMin());
   // AdfmfJavaUtilities.setELValue("#{pageFlowScope.viewportMaxValue}", event.getXMax());
  }
}

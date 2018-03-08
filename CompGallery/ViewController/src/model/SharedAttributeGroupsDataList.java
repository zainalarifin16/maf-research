package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SharedAttributeGroupsDataList
{
  private static String JANE = "JANE";
  private static String MARK = "MARK";
  private static String LISA = "LISA";
  private static String ALEX = "ALEX";
  private static String JOHN = "JOHN";
  private static String MELISSA = "MELISSA";

  private static List<SharedAttributeGroupsData> articles = new ArrayList<SharedAttributeGroupsData>();
  static
  {
    articles.add(createDataItem(2011, LISA, 60));
    articles.add(createDataItem(2012, LISA, 84));
    articles.add(createDataItem(2013, LISA, 94));
    articles.add(createDataItem(2014, LISA, 175));
    
    articles.add(createDataItem(2011, JOHN, 65));
    articles.add(createDataItem(2012, JOHN, 25));
    articles.add(createDataItem(2013, JOHN, 70));
    articles.add(createDataItem(2014, JOHN, 235));
    
    articles.add(createDataItem(2011, JANE, 247));
    articles.add(createDataItem(2012, JANE, 104));
    articles.add(createDataItem(2013, JANE, 134));
    articles.add(createDataItem(2014, JANE, 195));

    articles.add(createDataItem(2011, MARK, 30));
    articles.add(createDataItem(2012, MARK, 34));
    articles.add(createDataItem(2013, MARK, 80));
    articles.add(createDataItem(2014, MARK, 50));
  }

  private static SharedAttributeGroupsData createDataItem(int year, String author, int count)
  {
    return new SharedAttributeGroupsData(new Integer(year), author, new Integer(count));
  }

  public SharedAttributeGroupsData[] getArticlesPerYear2014()
  {
    return obtainArticlesPerYear(2014);
  }

  public SharedAttributeGroupsData[] getArticlesPerYear2013()
  {
    return obtainArticlesPerYear(2013);
  }

  public SharedAttributeGroupsData[] getArticlesPerYear2012()
  {
    return obtainArticlesPerYear(2012);
  }

  public SharedAttributeGroupsData[] getArticlesPerYear2011()
  {
    return obtainArticlesPerYear(2011);
  }

  private SharedAttributeGroupsData[] obtainArticlesPerYear(int year)
  {
    List<SharedAttributeGroupsData> ret = new ArrayList<SharedAttributeGroupsData>();

    Iterator<SharedAttributeGroupsData> iterator = articles.iterator();
    while (iterator.hasNext())
    {
      SharedAttributeGroupsData data = iterator.next();
      if (data.getYear().intValue() == year)
      {
        ret.add(data);
      }
    }

    return ret.toArray(new SharedAttributeGroupsData[ret.size()]);
  }

  public SharedAttributeGroupsData[] getAllArticles()
  {
    return articles.toArray(new SharedAttributeGroupsData[articles.size()]);
  }

  public SharedAttributeGroupsData[] getArticles()
  {
    Map<String, Integer> articlesPerPerson = new HashMap<String, Integer>();

    Iterator<SharedAttributeGroupsData> iterator = articles.iterator();
    while (iterator.hasNext())
    {
      SharedAttributeGroupsData data = iterator.next();
      String author = data.getAuthor();
      Integer count = null;
      if (articlesPerPerson.get(author) == null)
      {
        count = data.getCount();
      }
      else
      {
        count = new Integer((articlesPerPerson.get(author)).intValue() + data.getCount().intValue());
      }
      articlesPerPerson.put(author, count);
    }

    List<SharedAttributeGroupsData> ret = new ArrayList<SharedAttributeGroupsData>();

    Set<String> keys = articlesPerPerson.keySet();
    Iterator<String> iterator2 = keys.iterator();
    while (iterator2.hasNext())
    {
      String author = iterator2.next();
      ret.add(new SharedAttributeGroupsData(null, author, articlesPerPerson.get(author)));
    }

    return ret.toArray(new SharedAttributeGroupsData[ret.size()]);
  }

}

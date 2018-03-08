package model;

public class NBoxDataList
{
  private static NBoxNode[] nodes;
  
  public NBoxDataList()
  {
    if (nodes == null)
      nodes = new NBoxNode[] 
      {
        new NBoxNode ("1", "low", "low", "Nina Evans 1", "Product Management Director", "Manager", "Product Management", "3-5 years"),
        new NBoxNode ("2", "low", "low", "Jon Wu 3", "Vice President", "Manager", "Development", "3-5 years"), 
        new NBoxNode ("3", "low", "low", "Dan Raphaely 3", "Software Development Senior Director", "Manager", "Development", "6+ years"), 
        new NBoxNode ("5", "low", "low", "Laura Bissot 1", "Senior Documentation Manager", "Manager", "Documentation", "3-5 years"), 
        
        new NBoxNode ("4", "low", "medium", "Curtis Davies 1", "Principal Software Engineer", "Individual Contributor", "Development", "0-2 years"), 
        new NBoxNode ("6", "low", "medium", "James Marlow 1", "Senior Software Engineer", "Individual Contributor", "Development", "3-5 years"), 
        new NBoxNode ("2", "low", "medium", "Jon Wu 1", "Product Management Director", "Manager", "Product Management", "3-5 years"), 
        new NBoxNode ("3", "low", "medium", "Dan Raphaely 1", "Principal Product Manager", "Individual Contributor", "Product Management", "0-2 years"), 
        new NBoxNode ("7", "low", "medium", "Simon Austin 1", "Senior Product Manager", "Individual Contributor", "Product Management", "6+ years"), 
        
        new NBoxNode ("8", "low", "high", "Susan Higgins 3", "Senior Software Engineer", "Individual Contributor", "Development", "3-5 years"), 
        new NBoxNode ("9", "low", "high", "Kelly Sullivan 3", "Product Management Director", "Manager", "Product Management", "3-5 years"), 
        
        new NBoxNode ("8", "medium", "low", "Susan Higgins 1", "Principal Technical Writer", "Individual Contributor", "Documentation", "6+ years"), 
        new NBoxNode ("9", "medium", "low", "Kelly Sullivan 1", "Marketing Director", "Manager", "Marketing", "6+ years"), 
        new NBoxNode ("12", "medium", "low", "Julia Chen 1", "Principal Marketing Manager", "Individual Contributor", "Marketing", "0-2 years"), 
        new NBoxNode ("13", "medium", "low", "Alaina Walsh 1", "Senior Marketing Manager", "Individual Contributor", "Marketing", "3-5 years"), 
        new NBoxNode ("5", "medium", "low", "Nancy Green 1", "Vice President", "Manager", "Development", "3-5 years"), 
        
        new NBoxNode ("10", "medium", "medium", "David Yong 1", "Senior Documentation Manager", "Manager", "Documentation", "3-5 years"), 
        new NBoxNode ("1", "medium", "medium", "Nina Evans 2", "Principal Technical Writer", "Individual Contributor", "Documentation", "6+ years"), 
        new NBoxNode ("8", "medium", "medium", "Diana Lorentz 2", "Marketing Director", "Manager", "Marketing", "6+ years"), 
        new NBoxNode ("12", "medium", "medium", "Lucy Whalen 2", "Principal Marketing Manager", "Individual Contributor", "Marketing", "0-2 years"), 
        new NBoxNode ("5", "medium", "medium", "Laura Bissot 2", "Senior Marketing Manager", "Individual Contributor", "Marketing", "3-5 years"), 
        new NBoxNode ("8", "medium", "medium", "Susan Higgins 2", "Vice President", "Manager", "Development", "3-5 years"), 
        new NBoxNode ("9", "medium", "medium", "Kelly Sullivan 2", "Software Developer Senior Director", "Manager", "Development", "6+ years"), 
        new NBoxNode ("12", "medium", "medium", "Julia Chen 2", "Architect", "Individual Contributor", "Development", "0-2 years"), 
        new NBoxNode ("13", "medium", "medium", "Alaina Walsh 2", "Principal Software Engineer", "Individual Contributor", "Development", "0-2 years"), 
        new NBoxNode ("5", "medium", "medium", "Nancy Green 2", "Senior Software Engineer", "Individual Contributor", "Development", "3-5 years"), 
        new NBoxNode ("11", "medium", "medium", "Steven King 2", "Product Management Director", "Manager", "Product Management", "3-5 years"), 
        new NBoxNode ("7", "medium", "medium", "Alex Hunold 2", "Principal Product Manager", "Individual Contributor", "Product Management", "0-2 years"), 
        new NBoxNode ("4", "medium", "medium", "Curtis Davies 2", "Senior Product Manager", "Individual Contributor", "Product Management", "6+ years"), 
        new NBoxNode ("6", "medium", "medium", "James Marlow 2", "Senior Documentation Manager", "Manager", "Documentation", "3-5 years"), 
        new NBoxNode ("2", "medium", "medium", "Jon Wu 2", "Principal Technical Writer", "Individual Contributor", "Documentation", "6+ years"), 
        new NBoxNode ("3", "medium", "medium", "Dan Raphaely 2", "Marketing Director", "Manager", "Marketing", "6+ years"), 
        
        new NBoxNode ("12", "medium", "high", "Julia Chen 3", "Principal Product Manager", "Individual Contributor", "Product Management", "0-2 years"), 
        new NBoxNode ("13", "medium", "high", "Alaina Walsh 3", "Senior Product Manager", "Individual Contributor", "Product Management", "6+ years"), 
        new NBoxNode ("5", "medium", "high", "Nancy Green 3", "Denior Documentation Manager", "Manager", "Documentation", "3-5 years"), 
        new NBoxNode ("11", "medium", "high", "Steven King 3", "Principal Technical Writer", "Individual Contributor", "Documentation", "6+ years"), 
        new NBoxNode ("7", "medium", "high", "Alex Hunhold 3", "Marketing Director", "Manager", "Marketing", "6+ years"), 
        new NBoxNode ("4", "medium", "high", "Curtis Davies 3", "Principal Marketing Manager", "Individual Contributor", "Marketing", "0-2 years"), 
        
        new NBoxNode ("11", "high", "low", "Steven King 1", "Software Development Senior Director", "Manager", "Development", "6+ years"), 
        new NBoxNode ("7", "high", "low", "Alex Hunold 1", "Architect", "Individual Contributor", "Development", "0-2 years"), 
        
        new NBoxNode ("7", "high", "medium", "Simon Austin 2", "Principal Marketing Manager", "Individual Contributor", "Marketing", "0-2 years"), 
        new NBoxNode ("10", "high", "medium", "David Yong 2", "Senior Marketing Manager", "Individual Contributor", "Marketing", "3-5 years"), 
        new NBoxNode ("1", "high", "medium", "Nina Evans 3", "Vice President", "Manager", "Development", "3-5 years"), 
        new NBoxNode ("8", "high", "medium", "Diana Lorentz 3", "Software Developer Senior Director", "Manager", "Development", "6+ years"), 
        new NBoxNode ("12", "high", "medium", "Lucy Whalen 3", "Architect", "Individual Contributor", "Development", "0-2 years"),
        new NBoxNode ("5", "high", "medium", "Laura Bissot 3", "Principal Software Engineer", "Individual Contributor", "Development", "0-2 years"),
        
        new NBoxNode ("6", "high", "high", "James Marlow 3", "Senior Marketing Manager", "Individual Contributor", "Marketing", "3-5 years"),
        new NBoxNode ("8", "high", "high", "Diana Lorentz 1", "Principal Product Manager", "Individual Contributor", "Product Management", "0-2 years"),
        new NBoxNode ("12", "high", "high", "Lucy Whalen 1", "Senior Product Manager", "Individual Contributor", "Product Management", "6+ years"),
        new NBoxNode ("7", "high", "high", "Simon Austin 3", "Architect", "Individual Contributor", "Development", "0-2 years")
      };
  }

  public NBoxNode[] getNBoxNodesDataList ()
  {
    return nodes;
  }
}

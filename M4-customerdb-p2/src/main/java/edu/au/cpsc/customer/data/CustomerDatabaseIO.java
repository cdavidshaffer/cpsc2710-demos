package edu.au.cpsc.customer.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Read/write a CustomerDatabase from/to a file.  If you don't remember I/O, go to module 6 in your
 * CPSC1220 class on Canvas.
 * <p>
 * I'm going to use Object streams, which have been in Java since almost the first version.
 * </p><p>
 * I'm going to use try-with-resources statement which was added in Java 7 circa 2011 but wasn't
 * discussed in 1220.
 * </p>
 */
public class CustomerDatabaseIO {

  public static final File DEFAULT_FILE = new File("customers.dat");

  public static void save(CustomerDatabase cd, OutputStream strm) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(strm)) {
      oos.writeObject(cd);
    }
  }

  public static CustomerDatabase load(InputStream strm) throws IOException {
    try (ObjectInputStream ois = new ObjectInputStream(strm)) {
      return (CustomerDatabase)ois.readObject();
    } catch (ClassNotFoundException e) {
      System.out.println("Internal error: database file contains class that is not part of this Java runtime.");
      e.printStackTrace();
      System.exit(-1);
    }
    throw new RuntimeException("We reached a statement that can never be reached.");
  }

}

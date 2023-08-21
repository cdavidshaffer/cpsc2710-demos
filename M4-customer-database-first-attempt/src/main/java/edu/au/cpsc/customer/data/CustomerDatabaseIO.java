package edu.au.cpsc.customer.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class CustomerDatabaseIO {

  public static final File DEFAULT_FILE = new File("customers.dat");

  public static void save(CustomerDatabase database, OutputStream strm) throws IOException {
    ObjectOutputStream oos = new ObjectOutputStream(strm);
    oos.writeObject(database);
  }

  public static CustomerDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
    ObjectInputStream ois = new ObjectInputStream(strm);
    return (CustomerDatabase) ois.readObject();
  }

}

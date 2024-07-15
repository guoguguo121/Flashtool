package org.flashtool.flashsystem;

import java.util.ArrayList;
import java.util.List;

import org.flashtool.parsers.sin.SinFile;
import org.flashtool.parsers.sin.SinFileException;

public class Category implements Comparable<Category> {
		  
	private String id;
	private List<BundleEntry> entries = new ArrayList<BundleEntry>();
	private boolean enabled = false;
	private boolean issin = false;
	private boolean ista = false;
	private boolean isbootdelivery = false;
	private boolean ispartitiondelivery = false;
	private boolean ispartition = false;
	private boolean issecro = false;
	private boolean ispreload = false;
	private boolean iselabel = false;
	private boolean issystemuser = false;
	private boolean issw = false;

		  public String getId() {
		    return id;
		  }

		  public void setId(String id) {
		    this.id = id;
		  }

		  public List<BundleEntry> getEntries() {
		    return entries;
		  }
		  
		  public void addEntry(BundleEntry f) throws SinFileException {
			entries.add(f);
			update(f.getName());
		}
	
		private void update(String fileName) {
			if (fileName.endsWith(".sin")) issin = true;
			if (fileName.endsWith(".ta")) ista = true;
			if (fileName.contains("boot_delivery")) isbootdelivery = true;
			if (fileName.contains("partition_delivery")) ispartitiondelivery = true;
	
			if (issin) {
				if (fileName.toUpperCase().contains("PARTITION")) {
					ispartition = true;
				} else if (fileName.toUpperCase().contains("SECRO")) {
					issecro = true;
				} else if (fileName.toUpperCase().contains("PRELOAD")) {
					ispreload = true;
				} else if (fileName.toUpperCase().contains("ELABEL")) {
					iselabel = true;
				} else if (fileName.toUpperCase().contains("SYSTEM") || fileName.toUpperCase().contains("USER") || fileName.toUpperCase().contains("OEM") || fileName.toUpperCase().contains("VENDOR") || fileName.toUpperCase().contains("B2B") || fileName.toUpperCase().contains("SSD")) {
					issystemuser = true;
				} else {
					issw = true;
				}
			}
		  }

		  public boolean isPartition() {
			  return ispartition;
		  }

		  public boolean isSecro() {
			  return issecro;
		  }

		  public boolean isPreload() {
			  return ispreload;
		  }

		  public boolean isElabel() {
			  return iselabel;
		  }

		  public boolean isSystem() {
			  return issystemuser;
		  }

		  public boolean isSoftware() {
			  return issw;
		  }

		  public String toString() {
			  return id;
		  }

		  public boolean isTa() {
			  return ista;
		  }
		  
		  public boolean isSin() {
			  return issin;
		  }

		  public boolean isBootDelivery() {
			  return isbootdelivery;
		  }

		  public boolean isPartitionDelivery() {
			  return ispartitiondelivery;
		  }
		  
		  public boolean equals(Category c) {
			  return c.getId().equals(id);
		  }
		  
		  @Override
		  public int hashCode() { 
			  return id.hashCode();
		  }
		  
		  public boolean isEnabled() {
			  return enabled;
		  }
		  
		  @Override
		  public boolean equals(Object o) {
			  if (o instanceof String)
				  return id.equals((String)o);
			  if (o instanceof Category)
				  return ((Category)o).getId().equals(id);
			  return false;
		  }

		@Override
		public int compareTo(Category o) {
			return this.id.compareTo(o.getId());
		}
		
		public void setEnabled(boolean enabled) {
			this.enabled=enabled;
		}
		
		public static String getCategoryFromName(String name) {
			return SinFile.getShortName(name).toUpperCase();
		}
}

/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.model;

import lombok.Data;
import javax.persistence.*;

/**
 * TODO: Describe Me!
 */
@Data
@Entity
public class Site
{
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   Long id;

   String name;
   String location;

   public Site() {}

   public Site(long id) {
      this.id = id;
   }

   public Site(String name, String location) {
      this.name = name;
      this.location = location;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Site site = (Site) o;

      return id.equals(site.id);
   }

   @Override
   public int hashCode() {
      return id.hashCode();
   }

   @Override
   public String toString() {
      return "Site{" +
         "id=" + id +
         ", name='" + name + '\'' +
         ", location='" + location + '\'' +
         '}';
   }
}

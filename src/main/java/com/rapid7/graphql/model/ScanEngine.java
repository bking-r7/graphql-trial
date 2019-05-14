/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.model;

import java.util.UUID;
import lombok.Data;
import javax.persistence.*;

/**
 * TODO: Describe Me!
 */
@Data
@Entity
public class ScanEngine
{
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   Long id;

   UUID engineUuid;
   String state;
   String nextAction;
   Boolean isPaired = false;

   @ManyToOne
   @JoinColumn(name = "site_id", nullable = false, updatable = false)
   Site site;

   public ScanEngine() {}

   public ScanEngine(UUID engineUuid, String state, String nextAction, Boolean isPaired, Site site) {
      this.engineUuid = engineUuid;
      this.state = state;
      this.nextAction = nextAction;
      this.isPaired = isPaired;
      this.site = site;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ScanEngine scanEngine = (ScanEngine) o;

      return id.equals(scanEngine.id);
   }

   @Override
   public int hashCode() {
      return id.hashCode();
   }

   @Override
   public String toString() {
      return "ScanEngine{" +
         "id=" + id +
         ", engineUuid='" + engineUuid + '\'' +
         ", state='" + state + '\'' +
         ", nextAction='" + nextAction + '\'' +
         ", isPaired='" + isPaired + '\'' +
         ", site='" + site + '\'' +
         '}';
   }
}

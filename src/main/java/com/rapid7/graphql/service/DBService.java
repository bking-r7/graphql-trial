/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.service;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.repository.ScanEngineRepository;
import com.rapid7.graphql.repository.SiteRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * TODO: Describe Me!
 */
@Component
public class DBService
{
   private ScanEngineRepository scanEngineRepository;
   private SiteRepository siteRepository;

   public DBService(SiteRepository siteRepository, ScanEngineRepository scanEngineRepository)
   {
      this.siteRepository = siteRepository;
      this.scanEngineRepository = scanEngineRepository;
   }

   public Iterable<Site> findAllSites()
   {
      return siteRepository.findAll();
   }

   public Iterable<ScanEngine> findAllScanEngines()
   {
      return scanEngineRepository.findAll();
   }

   public long countSites()
   {
      return siteRepository.count();
   }

   public long countScanEngines()
   {
      return scanEngineRepository.count();
   }

   public Site newSite(String name, String location)
   {
      Site site = new Site();
      site.setName(name);
      site.setLocation(location);

      siteRepository.save(site);

      return site;
   }

   public ScanEngine newScanEngine(UUID engineUuid, String state, String nextAction, Boolean isPaired, Long siteId)
   {
      ScanEngine scanEngine = new ScanEngine();
      scanEngine.setEngineUuid(engineUuid);
      scanEngine.setState(state);
      scanEngine.setNextAction(nextAction);
      scanEngine.setIsPaired(isPaired);
      scanEngine.setSite(new Site(siteId));

      scanEngineRepository.save(scanEngine);

      return scanEngine;
   }

   public boolean deleteScanEngine(Long id) {
      scanEngineRepository.deleteById(id);
      return true;
   }

   public ScanEngine updateScanEngineIsPaired(Boolean isPaired, Long id) {
      ScanEngine scanEngine = scanEngineRepository.findById(id).get();
      scanEngine.setIsPaired(isPaired);

      scanEngineRepository.save(scanEngine);

      return scanEngine;
   }
}

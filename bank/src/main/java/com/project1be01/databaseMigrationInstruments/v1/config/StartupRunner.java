package com.project1be01.databaseMigrationInstruments.v1.config;

import com.project1be01.databaseMigrationInstruments.v1.config.DatabaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Slf4j
public class StartupRunner implements CommandLineRunner {

    private DatabaseConfig databaseConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("Load roles into database table ...");
        databaseConfig.fillRoleTable();
        log.info("Done...");
    }
}

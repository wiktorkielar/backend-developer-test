package com.wiktorkielar.backenddevelopertest.converter.impl;

import com.wiktorkielar.backenddevelopertest.converter.JsonToCountryConverter;
import com.wiktorkielar.backenddevelopertest.model.Country;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonToCountryConverterImplTest {

    private JsonToCountryConverter jsonToCountryConverter;

    @BeforeEach
    void setup() {
        jsonToCountryConverter = new JsonToCountryConverterImpl();
    }

    @Test
    void shouldReturnCountries() throws ParseException {
        //given
        String httpEntity = " [\n" +
                "    {\n" +
                "        \"name\": {\n" +
                "            \"common\": \"Afghanistan\",\n" +
                "            \"official\": \"Islamic Republic of Afghanistan\",\n" +
                "            \"native\": {\n" +
                "                \"prs\": {\n" +
                "                    \"official\": \"\\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc \\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                    \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "                },\n" +
                "                \"pus\": {\n" +
                "                    \"official\": \"\\u062f \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646 \\u0627\\u0633\\u0644\\u0627\\u0645\\u064a \\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc\\u062a\",\n" +
                "                    \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "                },\n" +
                "                \"tuk\": {\n" +
                "                    \"official\": \"Owganystan Yslam Respublikasy\",\n" +
                "                    \"common\": \"Owganystan\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"tld\": [\n" +
                "            \".af\"\n" +
                "        ],\n" +
                "        \"cca2\": \"AF\",\n" +
                "        \"ccn3\": \"004\",\n" +
                "        \"cca3\": \"AFG\",\n" +
                "        \"cioc\": \"AFG\",\n" +
                "        \"independent\": true,\n" +
                "        \"status\": \"officially-assigned\",\n" +
                "        \"unMember\": true,\n" +
                "        \"currencies\": {\n" +
                "            \"AFN\": {\n" +
                "                \"name\": \"Afghan afghani\",\n" +
                "                \"symbol\": \"\\u060b\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"idd\": {\n" +
                "            \"root\": \"+9\",\n" +
                "            \"suffixes\": [\n" +
                "                \"3\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"capital\": [\n" +
                "            \"Kabul\"\n" +
                "        ],\n" +
                "        \"altSpellings\": [\n" +
                "            \"AF\",\n" +
                "            \"Af\\u0121\\u0101nist\\u0101n\"\n" +
                "        ],\n" +
                "        \"region\": \"Asia\",\n" +
                "        \"subregion\": \"Southern Asia\",\n" +
                "        \"languages\": {\n" +
                "            \"prs\": \"Dari\",\n" +
                "            \"pus\": \"Pashto\",\n" +
                "            \"tuk\": \"Turkmen\"\n" +
                "        },\n" +
                "        \"translations\": {\n" +
                "            \"ces\": {\n" +
                "                \"official\": \"Afgh\\u00e1nsk\\u00e1 isl\\u00e1msk\\u00e1 republika\",\n" +
                "                \"common\": \"Afgh\\u00e1nist\\u00e1n\"\n" +
                "            },\n" +
                "            \"cym\": {\n" +
                "                \"official\": \"Gweriniaeth Islamaidd Affganistan\",\n" +
                "                \"common\": \"Affganistan\"\n" +
                "            },\n" +
                "            \"deu\": {\n" +
                "                \"official\": \"Islamische Republik Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"est\": {\n" +
                "                \"official\": \"Afganistani Islamivabariik\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"fin\": {\n" +
                "                \"official\": \"Afganistanin islamilainen tasavalta\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"official\": \"R\\u00e9publique islamique d'Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"hrv\": {\n" +
                "                \"official\": \"Islamska Republika Afganistan\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"hun\": {\n" +
                "                \"official\": \"Afganiszt\\u00e1ni Iszl\\u00e1m K\\u00f6zt\\u00e1rsas\\u00e1g\",\n" +
                "                \"common\": \"Afganiszt\\u00e1n\"\n" +
                "            },\n" +
                "            \"ita\": {\n" +
                "                \"official\": \"Repubblica islamica dell'Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"jpn\": {\n" +
                "                \"official\": \"\\u30a2\\u30d5\\u30ac\\u30cb\\u30b9\\u30bf\\u30f3\\u00b7\\u30a4\\u30b9\\u30e9\\u30e0\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u30a2\\u30d5\\u30ac\\u30cb\\u30b9\\u30bf\\u30f3\"\n" +
                "            },\n" +
                "            \"kor\": {\n" +
                "                \"official\": \"\\uc544\\ud504\\uac00\\ub2c8\\uc2a4\\ud0c4 \\uc774\\uc2ac\\ub78c \\uacf5\\ud654\\uad6d\",\n" +
                "                \"common\": \"\\uc544\\ud504\\uac00\\ub2c8\\uc2a4\\ud0c4\"\n" +
                "            },\n" +
                "            \"nld\": {\n" +
                "                \"official\": \"Islamitische Republiek Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"per\": {\n" +
                "                \"official\": \"\\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc \\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "            },\n" +
                "            \"pol\": {\n" +
                "                \"official\": \"Islamska Republika Afganistanu\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"por\": {\n" +
                "                \"official\": \"Rep\\u00fablica Isl\\u00e2mica do Afeganist\\u00e3o\",\n" +
                "                \"common\": \"Afeganist\\u00e3o\"\n" +
                "            },\n" +
                "            \"rus\": {\n" +
                "                \"official\": \"\\u0418\\u0441\\u043b\\u0430\\u043c\\u0441\\u043a\\u0430\\u044f \\u0420\\u0435\\u0441\\u043f\\u0443\\u0431\\u043b\\u0438\\u043a\\u0430 \\u0410\\u0444\\u0433\\u0430\\u043d\\u0438\\u0441\\u0442\\u0430\\u043d\",\n" +
                "                \"common\": \"\\u0410\\u0444\\u0433\\u0430\\u043d\\u0438\\u0441\\u0442\\u0430\\u043d\"\n" +
                "            },\n" +
                "            \"slk\": {\n" +
                "                \"official\": \"Afg\\u00e1nsky islamsk\\u00fd \\u0161t\\u00e1t\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"spa\": {\n" +
                "                \"official\": \"Rep\\u00fablica Isl\\u00e1mica de Afganist\\u00e1n\",\n" +
                "                \"common\": \"Afganist\\u00e1n\"\n" +
                "            },\n" +
                "            \"swe\": {\n" +
                "                \"official\": \"Islamiska republiken Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"urd\": {\n" +
                "                \"official\": \"\\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u062c\\u0645\\u06c1\\u0648\\u0631\\u06cc\\u06c1 \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "            },\n" +
                "            \"zho\": {\n" +
                "                \"official\": \"\\u963f\\u5bcc\\u6c57\\u4f0a\\u65af\\u5170\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u963f\\u5bcc\\u6c57\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latlng\": [\n" +
                "            33,\n" +
                "            65\n" +
                "        ],\n" +
                "        \"landlocked\": true,\n" +
                "        \"borders\": [\n" +
                "            \"IRN\",\n" +
                "            \"PAK\",\n" +
                "            \"TKM\",\n" +
                "            \"UZB\",\n" +
                "            \"TJK\",\n" +
                "            \"CHN\"\n" +
                "        ],\n" +
                "        \"area\": 652230,\n" +
                "        \"flag\": \"\\ud83c\\udde6\\ud83c\\uddeb\",\n" +
                "        \"demonyms\": {\n" +
                "            \"eng\": {\n" +
                "                \"f\": \"Afghan\",\n" +
                "                \"m\": \"Afghan\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"f\": \"Afghane\",\n" +
                "                \"m\": \"Afghan\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";
        List<Country> expectedCountries = List.of(new Country("AFG", List.of("IRN", "PAK", "TKM", "UZB", "TJK", "CHN")));

        //when
        List<Country> countries = jsonToCountryConverter.convert(httpEntity);

        //then
        assertEquals(expectedCountries, countries);

    }

}
.PHONY: prepl test test-clj test-cljs sync-pom

prepl:
	clj -Adev \
		-J-Dclojure.server.jvm="{:port 5005 :accept clojure.core.server/io-prepl}" \
		-J-Dclojure.server.node="{:port 5006 :accept cljs.server.node/prepl}"

test: test-clj test-cljs

test-clj:
	clj -Adev -m cognitect.test-runner

test-cljs:
	clj -Adev -m cljs-test-runner.main


# To publish, you should `make sync-pom`, commit any changes and then `mvn deploy`.
sync-pom:
	clj -Spom
	xmllint -o pom.xml --format pom.xml

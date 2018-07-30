(in-ns 'org.corfudb.shell)                                  ; so our IDE knows what NS we are using

(import org.docopt.Docopt)                                  ; parse some cmdline opts
(import java.time.Duration)


(def usage "corfu_remove_node, remove a node from the layout.
Usage:
  corfu_remove_node (-c <config>) (-n <endpoint>) [--force] [-t <timeout>] [-p <poll_interval>] [-y <retry>] [-e [-u <keystore> -f <keystore_password_file>] [-r <truststore> -w <truststore_password_file>] [-g -o <username_file> -j <password_file>]]
Options:
  -c <config>, --config <config>                                                         Configuration string to use.
  -n <endpoint>, --node <endpoint>                                                       Endpoint of node to be removed
  --force                                                                                Force remove
  -t <timeout>, --timeout <timeout>                                                      Timeout for the command to execute  [default: 600]
  -p <poll_interval>, --poll-interval <poll_interval>                                    Polling interval to assess state of the workflow [default: 1]
  -y <retry>, --retry <retry>                                                            Number of retry before giving up [default: 3]
  -e, --enable-tls                                                                       Enable TLS.
  -u <keystore>, --keystore=<keystore>                                                   Path to the key store.
  -f <keystore_password_file>, --keystore-password-file=<keystore_password_file>         Path to the file containing the key store password.
  -r <truststore>, --truststore=<truststore>                                             Path to the trust store.
  -w <truststore_password_file>, --truststore-password-file=<truststore_password_file>   Path to the file containing the trust store password.
  -g, --enable-sasl-plain-text-auth                                                      Enable SASL Plain Text Authentication.
  -o <username_file>, --sasl-plain-text-username-file=<username_file>                    Path to the file containing the username for SASL Plain Text Authentication.
  -j <password_file>, --sasl-plain-text-password-file=<password_file>                    Path to the file containing the password for SASL Plain Text Authentication.
  -h, --help     Show this screen.
")

; Parse the incoming docopt options.
(def localcmd (.. (new Docopt usage) (parse *args)))



(defn rm-node [endpoint]
      (println (.. (get-management-view)
                   (removeNode endpoint
                               (. Integer (parseInt (.. localcmd (get "--retry"))))
                               (. Duration (ofSeconds (. Integer (parseInt (.. localcmd (get "--timeout"))))))
                               (. Duration (ofSeconds (. Integer (parseInt (.. localcmd (get "--poll-interval"))))))))))

(defn rm-node-force [endpoint]
  (println (.. (get-management-view)
               (forceRemoveNode endpoint
                           (. Integer (parseInt (.. localcmd (get "--retry"))))
                           (. Duration (ofSeconds (. Integer (parseInt (.. localcmd (get "--timeout"))))))
                           (. Duration (ofSeconds (. Integer (parseInt (.. localcmd (get "--poll-interval"))))))))))


(get-runtime (.. localcmd (get "--config")) localcmd)
(connect-runtime)

; determine what to do
(cond (.. localcmd (get "--force"))
  (rm-node-force (.. localcmd (get "--node")))
  :else (rm-node (.. localcmd (get "--node"))))

